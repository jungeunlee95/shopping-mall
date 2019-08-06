package com.cafe24.shoppingmall.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.example.pjmall.backend.domain.User;


@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public ResponseEntity<JSONResult> hello(){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(JSONResult.success("Hello World"));
	}

	@PostMapping("/hello2")
	public ResponseEntity<JSONResult> hello2(@RequestBody User user){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(JSONResult.success("Hello World2"));
	}

	@GetMapping("/hello3")
	public ResponseEntity<JSONResult> hello3(){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(JSONResult.success("Hello World"));
	}
	
}