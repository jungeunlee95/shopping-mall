package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.CategoryService;
import com.cafe24.shoppingmall.vo.CategoryVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("adminCategoryAPIController")
@RequestMapping("/api/admin/category") 
//@Admin
public class AdminCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@ApiOperation(value="목록 가져오기")
	@GetMapping(value="/list") 
	public ResponseEntity<JSONResult> getList() {

		List<CategoryVo> list = categoryService.getCategoryList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	} 
	
	@ApiOperation(value="상위 카테고리 이름 중복 검사")
	@ApiImplicitParams({
		@ApiImplicitParam(name="name", value="name : 카테고리 이름", required=true, dataType="String", defaultValue="")
	})
	@GetMapping(value="/checkName") 
	public ResponseEntity<JSONResult> checkName(@RequestParam(value="name") String name) {

		Boolean exist = categoryService.checkName(name);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(exist));
	} 
	
	// 현재 카테고리의 depth(상위 or 하위)중 같은 groupNo(같은 상위카테고리를 가진)중에서 중복검사
	@ApiOperation(value="하위 카테고리 이름 중복 검사")
	@ApiImplicitParams({
		@ApiImplicitParam(name="CategoryVo", value="name: 카테고리이름  \n groupNo: 그룹넘버 \n depth: 하위레벨 "
				, required=true, dataType="CategoryVo", defaultValue="")
	})
	@GetMapping(value="/checkLowName") 
	public ResponseEntity<JSONResult> checkLowName(@RequestBody CategoryVo categoryVo) {

		Boolean exist = categoryService.checkName(categoryVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(exist));
	}	
	
	@ApiOperation(value="상위 카테고리 등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="CategoryVo", value="name : 카테고리 이름 \n ", required=true, dataType="CategoryVo", defaultValue="")
	})
	@PostMapping(value="/add") 
	public ResponseEntity<JSONResult> add(@RequestBody CategoryVo categoryVo) {
		
		Boolean result = categoryService.addCategory(categoryVo.getName());
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}	
	
	@ApiOperation(value="하위 카테고리 등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="CategoryVo", value="name : 카테고리 이름 \n depth: 깊이 \n groupNo: 그룹번호 ", required=true, dataType="CategoryVo", defaultValue="")
	})
	@PostMapping(value="/addLow") 
	public ResponseEntity<JSONResult> addLow(@RequestBody CategoryVo categoryVo) {
		
		Boolean result = categoryService.addCategory(categoryVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}	
	
	@ApiOperation(value="카테고리 수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name="CategoryVo", value="no : 카테고리 번호 \n name : 카테고리 이름", required=true, dataType="CategoryVo", defaultValue="")
	})
	@PutMapping(value="/modify") 
	public ResponseEntity<JSONResult> deleteUser(@RequestBody CategoryVo categoryVo) {

		Boolean result = categoryService.modifyCategory(categoryVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	} 
	
	@ApiOperation(value="카테고리 삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name="CategoryVo", value="no : 카테고리 번호", required=true, dataType="CategoryVo", defaultValue="")
	})
	@DeleteMapping(value="/delete") 
	public ResponseEntity<JSONResult> delete(@RequestBody CategoryVo categoryVo) {

		Boolean result = categoryService.deleteCategory(categoryVo.getNo());
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	} 

}
