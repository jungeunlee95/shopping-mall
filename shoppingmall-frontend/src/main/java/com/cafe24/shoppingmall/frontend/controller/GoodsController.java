package com.cafe24.shoppingmall.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.shoppingmall.frontend.service.GoodsService;
import com.cafe24.shoppingmall.frontend.vo.ProductVo;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	@ResponseBody
	@RequestMapping("/list")
	public String list(Model model) {
		List<ProductVo> list = goodsService.getList();
		model.addAttribute("productList", list);
		return "ok";
	}
	
	@RequestMapping("{no}")
	public String list(@PathVariable("no") Long no) {
		return "goods/item";
	}

}
