package com.example.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	// test - ex
	@ResponseBody
	@RequestMapping("/test1")
	public String test1() {
		
		return "Hello world!";
	}
}
