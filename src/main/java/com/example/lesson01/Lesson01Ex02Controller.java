package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// response가 없을때 view 화면으로 간다.
// HTML 화면으로 보내는 컨트롤러
// 여기에 @ResponseBody가 있으면 안된다!! 그러므로 RestController도 안됨. 
@Controller
public class Lesson01Ex02Controller {
	
	//http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02") // request 주소 두개 값이 잘못 되었을 때, 주소를 못찾았다면 이친구가 잘못
	public String ex02() {
		// return 되는 String은 html의 경로이다. (@ResponseBody가 없을 때)
		
		// return "/templates/lesson01/ex02.html"; 이렇게 적으니까 너무 귀찮으니,
		// 달라지는 부분을 타임리프를 사용해서 쉽게 할수있다."
		
		// 달라지는 부분
		// return "			 lesson01/ex02.html"; 이렇게만 적을수있다는 장점이 있다.
		return "lesson01/ex02"; //타임리프 관련 오류. response html view 경로 // 주소를 불러올 수 없다 하면 이친구가 잘못
	}
}
