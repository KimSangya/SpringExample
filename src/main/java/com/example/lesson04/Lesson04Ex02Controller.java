package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {
	
	@Autowired
	private StudentBO studentBO;
	
	// 학생 가입 화면
	// http://localhost/lesson04/ex02/add-student-view
	@GetMapping("/add-student-view")
	public String addStuentView() {
		return "lesson04/addStudent";
	}
	
	// DB Insert => 방금 가입된 학생 Select => 화면
	@PostMapping("/add-student")
	public String addStudent(
			@ModelAttribute Student student,
			Model model) { // heap 영역 안 id=0인 상태로 들어오게 되는 부분
		
		// DB Insert를 하는게 첫번째
		studentBO.addStudent(student);
		
		// DB select => 방금 가입된 학생
		int id = student.getId();
		Student latestStudent = studentBO.getLatestStudent(id);
		
		// model에 데이터를 담는다.
		model.addAttribute("student", latestStudent);
		
		
		// 화면 이동
		return "lesson04/afterAddStudent";
	}
}
