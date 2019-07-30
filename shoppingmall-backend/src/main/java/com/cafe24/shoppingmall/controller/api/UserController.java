package com.cafe24.shoppingmall.controller.api;


import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.UserService;
import com.cafe24.shoppingmall.vo.UserAddressVo;
import com.cafe24.shoppingmall.vo.UserVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	
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
	 
	@ApiOperation(value="회원 탈퇴")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="no : 번호", required=true, dataType="Long", defaultValue="")
	})
	@DeleteMapping(value="/deleteUser") 
	public ResponseEntity<JSONResult> deleteUser(@RequestParam(value = "no") Long no) {
		// 일치하는 email없으면 false
		userService.deleteUser(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("OK"));
	} 
	
	
	@ApiOperation(value="회원 주소지 등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="UserAddressVo", 
				value="userNo : 회원번호 \n "
					 +"addressCode : 우편코드 \n"
					 +"address : 주소 \n"
					 +"addressDetail : 상세주소 \n"
					 +"addressCheck : 주소 구분(집, 회사 ...) \n"
				, required=true, dataType="Long", defaultValue="")
	})
	@PostMapping(value="/addAddress") 
	public ResponseEntity<JSONResult> addAddress(@RequestBody UserAddressVo userAddressVo) {
		Boolean result = userService.addAddress(userAddressVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	} 
	
	
	@ApiOperation(value="회원 주소지 리스트 가져오기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userNo", value="userNo : 회원번호", required=true, dataType="Long", defaultValue="")
	})
	@GetMapping(value="/getAddressList") 
	public ResponseEntity<JSONResult> getAddressList(@RequestParam(value = "userNo") Long userNo) {
		List<UserAddressVo> result = userService.getAddressList(userNo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	} 
	
	@ApiOperation(value="회원 주소지 가져오기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="addressNo", value="addressNo : 주소지번호", required=true, dataType="Long", defaultValue="")
	})
	@GetMapping(value="/getAddress") 
	public ResponseEntity<JSONResult> getAddress(@RequestParam(value = "addressNo") Long addressNo) {
		UserAddressVo result = userService.getAddress(addressNo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	} 
	
	@ApiOperation(value="회원 주소지 삭제하기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="addressNo", value="addressNo : 주소지번호", required=true, dataType="Long", defaultValue="")
	})
	@DeleteMapping(value="/deleteAddress") 
	public ResponseEntity<JSONResult> deleteAddress(@RequestParam(value = "addressNo") Long addressNo) {
		Boolean result = userService.deleteAddress(addressNo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	} 
	

	
}
 