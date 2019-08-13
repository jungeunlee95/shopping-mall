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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.dto.RequestDeleteCartDto;
import com.cafe24.shoppingmall.dto.RequestNonUserAddCartDto;
import com.cafe24.shoppingmall.dto.RequestNonUserOrderDto;
import com.cafe24.shoppingmall.dto.RequestNonUserOrderListDto;
import com.cafe24.shoppingmall.service.CartService;
import com.cafe24.shoppingmall.service.CategoryService;
import com.cafe24.shoppingmall.service.OrderService;
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.service.UserService;
import com.cafe24.shoppingmall.vo.CartVo;
import com.cafe24.shoppingmall.vo.CategoryVo;
import com.cafe24.shoppingmall.vo.OptionNameVo;
import com.cafe24.shoppingmall.vo.OrderDetailVo;
import com.cafe24.shoppingmall.vo.OrderVo;
import com.cafe24.shoppingmall.vo.UserVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("nonUserAPIController")
@RequestMapping("/api/nonuser")
public class NonUserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CategoryService categoryService;
	
	@ApiOperation(value="회원가입")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userVo", value="id: 아이디 - 필수값 \n password: 비밀번호 - 필수값 \n name: 이름 - 필수값 \n"
				+ "passwordQuestion: 비밀번호 질문 - 필수값 \n"
				+ "passwordAnswer: 비밀번호 대답 - 필수값 \n"
				+ "phoneNumber: 전화번호 - 필수값 \n"
				+ "birthDate: 생일 - 선택값 \n"
				+ "email: 이메일 - 선택값 \n", required=true, dataType="UserVo", defaultValue="")
	})

	@PostMapping(value="/join") 
	public ResponseEntity<JSONResult> joinUser(@RequestBody @Valid UserVo userVo,
								BindingResult bindingResult) {
		// java @valid 유효성 검증
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for(ObjectError error : allErrors) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		} 
		 
		// 있는 id면 fail
		if(!userService.checkId(userVo.getId())) { 
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(false));
		}
		 
		Boolean result = userService.joinUser(userVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
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
		@ApiImplicitParam(name="userVo", value="userId: 아이디 - 필수값 \n password: 비밀번호 - 필수값 \n"
				, dataType="userVo")
	})
	@PostMapping(value="/login")  
	public ResponseEntity<JSONResult> login(@RequestBody UserVo userVo) {
//		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
//		
//		Set<ConstraintViolation<UserVo>> validatorResults = validator.validateProperty(userVo, "id");
//		
//		if(validatorResults.isEmpty() == false) {
//			for( ConstraintViolation<UserVo> validatorResult : validatorResults ) {
//				String message = validatorResult.getMessage();
//				JSONResult result = JSONResult.fail(message);
//				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);				
//			} 
//		}
		
//		UserVo user = userService.getUser(userVo.getId(), userVo.getPassword());
		UserVo user = userService.getLogin(userVo.getId()); 
		
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

	
	//==================================================================================
	// 								비회원 장바구니 관리
	//==================================================================================
	
	@ApiOperation(value="장바구니에 상품 추가하기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="nonUserNo", value="nonUserNo: 비회원번호", required=false, dataType="Long", defaultValue=""),
		@ApiImplicitParam(name="productOptionNo", value="productOptionNo: 상품의 옵션 번호", required=true, dataType="Long", defaultValue=""),
		@ApiImplicitParam(name="quantity", value="quantity: 수량", required=true, dataType="Long", defaultValue="")
	})
	@PostMapping(value = "/cart/add")
	public ResponseEntity<JSONResult> addNonUserCart(@RequestBody @Valid RequestNonUserAddCartDto nonUserAddCartDto
			, BindingResult bindingResult) {
		// java @valid 유효성 검증
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for(ObjectError error : allErrors) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}
		
		boolean result = cartService.addCart(nonUserAddCartDto);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value="장바구니 목록 가져오기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="nonUserNo", value="nonUserNo: 비회원번호", required=false, dataType="String", defaultValue="")
	})
	@GetMapping(value = "/cart/getList")
	public JSONResult getCartList(@RequestBody @Valid RequestNonUserAddCartDto nonUserAddCartDto
			, BindingResult bindingResult) {
		// 상품 list return
		List<CartVo> list = cartService.getCartList(nonUserAddCartDto);
		return JSONResult.success(list);
	}
	
	@ApiOperation(value="장바구니 상품의 옵션 목록 가져오기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="no: 상품옵션번호", required=false, dataType="long", defaultValue="")
	})
	@GetMapping(value = "/cart/getOptionList")
	public JSONResult getOptionList(
			@RequestParam(value="no", required = true, defaultValue = "") Long no
			) {
		// 상품의 옵션 list return
		List<OptionNameVo> list = productService.getOptionList(no);
		return JSONResult.success(list);
	}
	
	@ApiOperation(value="장바구니 상품 삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name="List<RequestDeleteCartDto>", value="no: 장바구니 번호", required=true, dataType="List<RequestDeleteCartDto>", defaultValue="")
		
	})
	@DeleteMapping(value = "/cart/delete")
	public JSONResult deleteCart(@RequestBody List<RequestDeleteCartDto> noList) {
		Boolean result = cartService.deleteCart(noList);
		return JSONResult.success(result);
	}
	
	
	//==================================================================================
	// 									비회원 주문 관리
	//==================================================================================
//	@ApiOperation(value="비회원 주문하기")
//	@ApiImplicitParams({
//		@ApiImplicitParam(name="RequestNonUserOrderDto", 
//				value="nonUserNo : 비회원번호(세션) \n "
//				+ "name : 비회원 이름\n "
//				+ "gender : 성별 \n "
//				+ "password : 비밀번호 \n "
//				+ "phoneNumber : 전화번호 \n "
//				+ "email : 이메일 \n "
//				+ "address : address \n "
//				+ "totalPrice : 가격 \n "
//				+ "message : 배송매세지 \n ", required=true, dataType="RequestNonUserOrderDto", defaultValue="")
//	})
//	@PostMapping(value="/order/add") 
//	public ResponseEntity<JSONResult> add(@RequestBody RequestNonUserOrderDto requestNonUserOrderDto) {
//		
//		Boolean result = orderService.addOrder(requestNonUserOrderDto);
//		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
//	}	
	
	@ApiOperation(value="비회원 주문 목록 가져오기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="OrderVo", 
				value="orderStringNo : 주문번호 "
				+ "password : 비밀번호 \n ", required=true, dataType="OrderVo", defaultValue="")
	})
	@GetMapping(value="/order/list") 
	public ResponseEntity<JSONResult> getList(@RequestBody RequestNonUserOrderListDto requestNonUserOrderListDto) {
		List<OrderVo> list = orderService.getOrderListByNo(requestNonUserOrderListDto);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	} 
	
	@ApiOperation(value="비회원 주문 상세 목록 가져오기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", 
				value="no : 주문 PK 번호 ", required=true, dataType="OrderVo", defaultValue="")
	})
	@GetMapping(value="/order/detail/{no}") 
	public ResponseEntity<JSONResult> getOrderDetailList(@PathVariable(value="no") Long no) {
		
		List<OrderDetailVo> list = orderService.getOrderDetailList(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	//============= 카테고리 목록 ==================
	@ApiOperation(value="카테고리 전체 목록 가져오기")
	@GetMapping(value="/category/list") 
	public ResponseEntity<JSONResult> getList() {

		List<CategoryVo> list = categoryService.getCategoryList();
//		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list)); 
		return new ResponseEntity<JSONResult>(JSONResult.success(list), HttpStatus.OK);
	} 
	
	@ApiOperation(value="하위 카테고리 목록 가져오기")
	@GetMapping(value="/category/lowList") 
	public ResponseEntity<JSONResult> getLowList() {
		
		List<CategoryVo> list = categoryService.getCategoryLowList();
//		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list)); 
		return new ResponseEntity<JSONResult>(JSONResult.success(list), HttpStatus.OK);
	} 
}
















 