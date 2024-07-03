package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	// C:create
	@GetMapping("/create")
	public StudentEntity create() {
		String name = "김건호";
		String phoneNumber = "010-4714-5987";
		String email = "rjdgh456@naver.com";
		String dreamJob = "프로그래머";
		
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	// U : update
	@GetMapping("/update")
	public StudentEntity update() {
		// id가 7번인  dreamJob 변경(기획)
		return studentBO.updateStudentDreamJobById(7, "기획자");
	}
	
	// D : delete
	@GetMapping("/delete")
	public String delete() {
		// id가 8번인 데이터 삭제
		studentBO.deleteStudentById(8);
		
		return "삭제 성공!";
	}
}
