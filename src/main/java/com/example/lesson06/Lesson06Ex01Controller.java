package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson06/ex01")
@Controller
public class Lesson06Ex01Controller {
	
	@Autowired
	private UserBO userBO;
	
	// 회원 가입 화면
	// http://localhost/lesson06/ex01/add-user-view
	@GetMapping("/add-user-view")
	public String addUserView() {
		return "lesson06/addUser";
	}
	
	// AJAX가 하는 요청 -> AJAX가 하는 응답 값은 반드시 String이다.
	@ResponseBody // AJAX가 하는 요청은 무조건 responseBODY가 붙어야한다.
	@PostMapping("/add-user")
	// 응답을 하고자 하는 단어는 주소값이 아닌 가져오는 단어들.
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value = "introduce", required = false) String introduce) {
		// db insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		// 응답값 - response body에 "성공" 들어감
		return "성공";
	}
	
	// 회원가입 성공 화면
	@GetMapping("/after-add-user-view")
	public String afterAddUserView() {
		return "lesson06/afterAddUser";
	}
	
}
