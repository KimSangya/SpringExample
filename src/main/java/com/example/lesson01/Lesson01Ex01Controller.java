package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01") // 얘를 먼저 읽고, 그 하위에 있는 친구들도 적용됨.
@Controller // Spring bean으로 등록, 항상 먼저 만들어야 하는 어노테이션
public class Lesson01Ex01Controller {
	
	// http://localhost:8080/lesson01/ex01/1
	@ResponseBody // 리턴되는 값이 Response Body에 넣어진다. => HTML 응답
	@RequestMapping("/1") // path를 정의 하는 어노테이션
	public String ex01_1() { // String으로 리턴을 주면 html
		return "<h2>문자열을 Response Body에 보내주는 예제</h2>"; 
	}
	
	
	// 상단에 ResponseBody에 적는 것도 가능하고, 리턴타입 옆에 적는것도 있다.
	// http://localhost:8080/lesson01/ex01/2
	// Map 리턴 => JSON 변환
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> ex01_2() { // Map으로 리턴을 주면 jackson으로 리턴값을 받는다.
		// {"사과" = 20}
		Map<String, Object> map = new HashMap<>();
		map.put("사과", 20);
		map.put("포도", 30);
		map.put("딸기", 40);
		map.put("수박", 50);
		
		// java map을 리턴 하면 JSON으로 변환된다.
		// web starter 라이브러리에 jackson 라이브러리가 포함되어 있기 때문이다.
		
		return map;
	}
}
