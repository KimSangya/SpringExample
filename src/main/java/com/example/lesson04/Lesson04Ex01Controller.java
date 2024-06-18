package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;

@RequestMapping("/lesson04/ex01")
@Controller // html 화면인 경우 @ResponseBody 사용 안함
public class Lesson04Ex01Controller {
	
	@Autowired
	private UserBO userBO;
	
	// 회원가입 화면
	// http://localhost/lesson04/ex01/add-user-view
	@RequestMapping(path = "/add-user-view", method = RequestMethod.GET)
	public String addUserView() {
		return "lesson04/addUser"; // html view 경로
		// 404에러가 발생할경우, 주소를 못찾거나 
	}
	
	// 회원 가입 진행 => DB 저장 => 결과 화면
	@PostMapping("/add-user")
	public String adduser(
			@RequestParam("name") String name, 
			@RequestParam("yyyymmdd") String yyyymmdd, 
			@RequestParam("email") String email, 
			@RequestParam(value = "introduce", required = false) String introduce) {
		
		// DB 저장 - insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		// 결과 화면
		return "lesson04/afterAddUser";
	}
	
	// 최근 가입자 뿌리는 화면
	// http://localhost/lesson04/ex01/latest-user-view
	@GetMapping("/latest-user-view")
	public String latestUserView(Model model) { // Model : view 화면에서 데이터를 꺼내 쓸 수 있는 객체이다.
		// DB select (최신 가입자 1명)
		User user = userBO.getLatestUser();
		
		//Model 주머니에 담는다. => html에서 꺼내쓴다.
		model.addAttribute("result", user);
		model.addAttribute("title", "최근 가입한 유저 정보!");
		
		
		
		// 화면 이동
		return "lesson04/latestUser";
	}
}
