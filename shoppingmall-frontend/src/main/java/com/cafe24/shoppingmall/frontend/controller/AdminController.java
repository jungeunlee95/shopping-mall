package com.cafe24.shoppingmall.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.shoppingmall.frontend.dto.OrderDto;
import com.cafe24.shoppingmall.frontend.dto.ProductAddDto;
import com.cafe24.shoppingmall.frontend.service.CategoryService;
import com.cafe24.shoppingmall.frontend.service.FileuploadService;
import com.cafe24.shoppingmall.frontend.service.OrderService;
import com.cafe24.shoppingmall.frontend.service.ProductService;
import com.cafe24.shoppingmall.frontend.service.UserService;
import com.cafe24.shoppingmall.frontend.vo.CartVo;
import com.cafe24.shoppingmall.frontend.vo.CategoryVo;
import com.cafe24.shoppingmall.frontend.vo.OrderDetailVo;
import com.cafe24.shoppingmall.frontend.vo.ProductVo;
import com.cafe24.shoppingmall.frontend.vo.UserVo;

@Controller
@RequestMapping( "/admin"  )
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private FileuploadService fileuploadService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping( "" )
	public String login() {
		return "admin/main";
	}

	@GetMapping( "/user/list" )
	public String userList(Model model) {
		List<UserVo> list = userService.getUserList();
		model.addAttribute("userList", list);
		return "admin/user-list";
	}
	
	@GetMapping( "/user/{no}" ) 
	public String userDetail(Model model, @PathVariable("no") Long userNo) {
		
		UserVo user = userService.getUserDetail(userNo);
		model.addAttribute("user", user);
		
		List<CartVo> cartList = userService.getUserCartList(userNo);
		model.addAttribute("cartList", cartList);
		
		return "admin/user-detail"; 
	}
	 
	@GetMapping( "/product" )
	public String product(Model model) {
		List<CategoryVo> list = categoryService.getLowList();
		model.addAttribute("categoryLowList", list);
		return "admin/add-product"; 
	}
	
	@GetMapping( "/product/list" )
	public String productList(Model model) {
		List<ProductVo> list = productService.getList();
		model.addAttribute("productList", list);
		return "admin/product-list";
	} 
	
	@GetMapping( "/product/list/{page}" )
	public String productList(@PathVariable("page") Long page,  
			@RequestParam(value="keyword", required = false, defaultValue = "") String keyword,
			Model model) { 
		
		List<ProductVo> list = productService.getList(page, keyword);
		model.addAttribute("productList", list);
		return "admin/product-list";
	} 
	
	@PostMapping( "/product/add" )  
	public String productAdd( 
			@RequestParam(value="mainImg", required = false) MultipartFile multipartFile,
			Model model, 
			@ModelAttribute ProductAddDto pdto) { 
		String url = fileuploadService.restore(multipartFile);
		pdto.setMainImgUrl(url);
		Boolean result = productService.addProduct(pdto);
		
		model.addAttribute("result", result); 
 
		return  "redirect:/admin/product/list";
	}
	
	@GetMapping( "/order/list" )
	public String orderList(Model model) {
		List<OrderDto> list = orderService.getList();
		model.addAttribute("orderList", list);
		return "admin/order-list";  
	}
	
	@GetMapping( "/order/detail/{orderNo}/{userNo}" ) 
	public String orderDetail(Model model, @PathVariable("orderNo") Long orderNo
								, @PathVariable("userNo") Long userNo) {
		
		UserVo user = userService.getUserDetail(userNo);
		model.addAttribute("user", user);
		
		List<OrderDetailVo> orderList = orderService.getDetail(orderNo);
		model.addAttribute("orderList", orderList);
		return "admin/order-detail";   
	}
}
