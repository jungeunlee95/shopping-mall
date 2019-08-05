package com.example.shoppingmall.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.shoppingmall.frontend.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	@ResponseBody
	@RequestMapping("/list/{page}")
	public String list(@PathVariable("page") Integer page) {
		goodsService.getList();
		return "ok";
	}
}
