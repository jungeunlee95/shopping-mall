package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.service.UserService;
import com.cafe24.shoppingmall.vo.OptionNameVo;
import com.cafe24.shoppingmall.vo.OptionValueVo;
import com.cafe24.shoppingmall.vo.OptionVo;
import com.cafe24.shoppingmall.vo.ProductVo;
import com.cafe24.shoppingmall.vo.UserVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("adminUserAPIController")
@RequestMapping("/api/admin/user") 
public class AdminUserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="회원 목록")
	@GetMapping(value="/list") 
	public ResponseEntity<JSONResult> userList() {
		List<UserVo> list = userService.getUserList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));			
	} 
	
	@ApiOperation(value="회원 상세 정보") 
	@GetMapping(value="/detail/{userNo}") 
	public ResponseEntity<JSONResult> userDetail(@PathVariable(value="userNo") Long userNo) {
		UserVo vo = userService.getUserDetail(userNo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));			
	}   
	
	@ApiOperation(value="회원 정보 수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userVo", value="no: 회원번호 \n id: 아이디  \n password: 비밀번호 \n name: 이름  \n"
				+ "passwordQuestion: 비밀번호 질문 \n"
				+ "passwordAnswer: 비밀번호 대답 \n"
				+ "phoneNumber: 전화번호 \n"
				+ "birthDate: 생일 \n"
				+ "email: 이메일 \n", required=true, dataType="UserVo", defaultValue="")
	})
	@PutMapping(value="/modify") 
	public ResponseEntity<JSONResult> modifyUser(@RequestBody @Valid UserVo userVo,
								BindingResult result) {
		// java @valid 유효성 검증
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for(ObjectError error : allErrors) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}

		// id 중복검사
		UserVo vo = userService.modifyUser(userVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	} 
	 
	@ApiOperation(value="회원삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="no : 번호", required=true, dataType="Long", defaultValue="")
	})
	@DeleteMapping(value="/deleteUser") 
	public ResponseEntity<JSONResult> deleteUser(@RequestParam(value = "no") Long no) {
		// 일치하는 email없으면 false
		userService.deleteUser(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("OK"));
	}

}
