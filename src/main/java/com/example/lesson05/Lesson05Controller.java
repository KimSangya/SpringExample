package com.example.lesson05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {

	@GetMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		// List<String>
		List<String> fruits = new ArrayList<>();
		fruits.add("사과");
		fruits.add("배");
		fruits.add("수박");
		fruits.add("참외");
		fruits.add("딸기");
		
		model.addAttribute("fruits", fruits);
		
		//List<Map<String, Object>> 
		List<Map<String, Object>> users = new ArrayList<>();
		Map<String, Object> user = new HashMap<>();
		user.put("name", "최승은");
		user.put("age", 30);
		user.put("hobby", "영화보기");
		users.add(user);
		
		user = new HashMap<>();
		user.put("name", "조경아");
		user.put("age", 26);
		user.put("hobby", "요가하기");
		users.add(user);
		
		model.addAttribute("users", users);
		
		return "lesson05/ex02";
	}
}
