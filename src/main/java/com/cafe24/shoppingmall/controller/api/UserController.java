package com.cafe24.shoppingmall.controller.api;


import java.util.List;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.impl.UserServiceImpl;
import com.cafe24.shoppingmall.vo.UserVo;

@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value="/join", method=RequestMethod.POST) 
	public ResponseEntity<JSONResult> joinUser(@RequestBody @Valid UserVo userVo,
								BindingResult result) {
		// java @valid 유효성 검증
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for(ObjectError error : allErrors) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}
		
		// 정규식 유효성 검증
		if(!Pattern.matches(UserVo.CHECK_ID_VALID, userVo.getId())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("잘못된 아이디 형식입니다."));
		}else if(!Pattern.matches(UserVo.CHECK_PASSWORD_VALID, userVo.getPassword())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("잘못된 비밀번호 형식입니다."));
		}else if(!Pattern.matches(UserVo.CHECK_PHONE_VALID, userVo.getPhoneNumber())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("잘못된 전화번호 형식입니다."));
		}else if(!Pattern.matches(UserVo.CHECK_NAME_VALID, userVo.getName())){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("잘못된 이름 형식입니다."));
		}
		
		UserVo vo = userService.joinUser(userVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	

	@RequestMapping(value="/checkId", method=RequestMethod.GET) 
	public ResponseEntity<JSONResult> checkId(@RequestParam(value="id") String id) {
		// id 정규식 검증 
		if(!Pattern.matches(UserVo.CHECK_ID_VALID, id)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("잘못된 아이디 형식입니다."));
		}
		
		Boolean exist = userService.checkId(id);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(exist));
	} 
	
	@RequestMapping(value="/login", method=RequestMethod.GET) 
	public ResponseEntity<JSONResult> login(@RequestParam(value="id") String id, 
							@RequestParam(value="password") String password) {
		Boolean exist = userService.getUser(id, password);
	    return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(exist));
	} 
	
	@RequestMapping(value="/findId", method=RequestMethod.GET) 
	public ResponseEntity<JSONResult> findId(@RequestParam(value = "email") String email) {
		// 일치하는 email없으면 false
		String userId = userService.getUser(email);
		if(userId!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(userId));
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("해당하는 아이디가 없습니다."));			
		}
	} 
	
	

	
}
 