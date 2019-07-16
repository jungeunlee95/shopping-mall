package com.cafe24.shoppingmall.controller.api;


import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.UserService;
import com.cafe24.shoppingmall.vo.UserVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="회원가입")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userVo", value="userId: 아이디 - 필수값 \n password: 비밀번호 - 필수값 \n name: 이름 - 필수값 \n"
				+ "passwordQuestion: 비밀번호 질문 - 필수값 \n"
				+ "passwordAnswer: 비밀번호 대답 - 필수값 \n"
				+ "phoneNumber: 전화번호 - 필수값 \n"
				+ "email: 이메일 - 선택값 \n", required=true, dataType="UserVo", defaultValue="")
	})
	@PostMapping(value="/join") 
	public ResponseEntity<JSONResult> joinUser(@RequestBody @Valid UserVo userVo,
								BindingResult result) {
		
		// java @valid 유효성 검증
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for(ObjectError error : allErrors) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}

		// id 중복검사
		UserVo vo = userService.joinUser(userVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}	

	@ApiOperation(value="아이디 중복 검사")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id", value="id : 아이디", required=true, dataType="String", defaultValue="")
	})
	@GetMapping(value="/checkId") 
	public ResponseEntity<JSONResult> checkId(@RequestParam(value="id") String id) {

		Boolean exist = userService.checkId(id);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(exist));
	} 
	
	
	@ApiOperation(value="로그인")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userVo", value="userId: 아이디 - 필수값 \n password: 비밀번호 - 필수값 \n")
	})
	@GetMapping(value="/login") 
	public ResponseEntity<JSONResult> login(@RequestBody UserVo userVo) {
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		
		Set<ConstraintViolation<UserVo>> validatorResults = validator.validateProperty(userVo, "id");
		
		if(validatorResults.isEmpty() == false) {
			for( ConstraintViolation<UserVo> validatorResult : validatorResults ) {
				String message = validatorResult.getMessage();
				JSONResult result = JSONResult.fail(message);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);				
			}
		}
		
		UserVo user = userService.getUser(userVo.getId(), userVo.getPassword());
		
		// 로그인 실패
		if(user == null) {
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail("아이디나 비밀번호 값이 잘못 되었습니다."));			
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(user));			
	} 
	
	
	@ApiOperation(value="아이디 찾기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="email", value="email : 이메일", required=true, dataType="String", defaultValue="")
	})
	@GetMapping(value="/findId") 
	public ResponseEntity<JSONResult> findId(@RequestParam(value = "email") String email) {
		// 일치하는 email없으면 false
		UserVo userVo = userService.getUser(email);
		if(userVo!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(userVo.getId()));
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("해당하는 아이디가 없습니다."));			
		}
	} 
	
	@ApiOperation(value="회원 목록")
	@GetMapping(value="/userList") 
	public ResponseEntity<JSONResult> userList() {
		List<UserVo> list = userService.getUserList();

		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));			

	} 
	
	

	
}
 