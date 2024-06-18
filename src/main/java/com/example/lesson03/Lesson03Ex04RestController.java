package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;

@RequestMapping("/lesson03/ex04")
@RestController
public class Lesson03Ex04RestController {

	@Autowired
	private ReviewBO reviewBO;
	
	//http://localhost/lesson03/ex04/1?id=23
	@RequestMapping("/1")
	public String ex04(
			@RequestParam("id") int id) {
		reviewBO.deleteReviewById(id);
		return "삭제 성공!";
	}
}
