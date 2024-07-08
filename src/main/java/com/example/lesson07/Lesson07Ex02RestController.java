package com.example.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@RequestMapping("/lesson07/ex02")
@RestController
public class Lesson07Ex02RestController {
	
	// !!!!!!!!! 이번에만 BO 생략 스프링의 구조상 인원이 더 많은게 좋아서 따로 프로젝트를 사용할때는 무조건 있는게 좋음
	@Autowired 
	private StudentRepository studentRepository;
	
	// 조회하는 다양한 방법
	@GetMapping("/select1")
	public List<StudentEntity> select1() {
		// 1) 전체 조회 (기본으로 제공됨)
		 return studentRepository.findAll();
		
		// 2) id 기준 내림차순 전체 조회 orderBy 
		// return studentRepository.findAllByOrderByIdDesc();
		
		// 3) id 기준 내림차순 3개만 조회 limit 3
		// return studentRepository.findTop3ByOrderByIdDesc();
		
		// 4) 이름이 김바다인 데이터 조회
		// return studentRepository.findByName("김건호"); // ? 왜 가능하냐? -> 엔티티에서 네임 컬럼을 찾아서 넣어주는 기능으로 동작을 하기 때문에 가능하다.
		
		// 5) in문으로 일치하는 모든 값 조회 / 이름 허용할것들만 허용 해놓으면 다 가능하다. in문으로 만드는 방식
		// return studentRepository.findByNameIn(List.of("조세호", "유재석")); // ex : 이름이 일치하는 두개의 행을 가져온다. 
		
		// 6) 여러 컬럼값과 일치하는 데이터 조회 - > 이름도 일치 하면서 dreamjob도 일치하는 경우
		// return studentRepository.findByNameAndDreamJob("조세호", "변호사"); 
		
		// 7) email 컬럼에 kakao가 포함된 데이터 조회 like '%kakao%'
		// return studentRepository.findByEmailContains("gmail");
		
		// 8) 김으로 시작하는 데이터 조회 like '김%'
		// return studentRepository.findByNameStartingWith("김");
		
		// 9) id가 2~5까지 조회 between
		// return studentRepository.findByIdBetween(2, 5);
		
	}
	
	@GetMapping("/select2")
	public List<StudentEntity> select2() {
		// 장래희망이 개발자인 데이터 조회
		return studentRepository.findByDreamJob("래퍼");
	}
}
