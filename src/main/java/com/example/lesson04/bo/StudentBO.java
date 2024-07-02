package com.example.lesson04.bo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired // 따로 따로 Autowired를 적용시켜줘야한다.
	private StudentRepository studentRepository;
	
	// input : 파라미터 4개
	// output : StudentEntity
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {
		StudentEntity student = StudentEntity.builder() // 빌더 패턴 Lombok을 사용하지 않으면 나오지 않음.
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.build(); // 뚜껑을 닫으려고 하는 패턴 방법
				//시간을 임의로 넣으려고 한다면? .createdAt(LocalDateTime.now()) @creationTimeStamp있으면 생략 가능.
		return studentRepository.save(student); // 이친구 자체적으로 세이브를 해서 리턴을 해줘도 좋다라는것이다.
	}
	
	// input : Student
	// output : X
	public void addStudent(Student studnet) {
		studentMapper.insertStudent(studnet);
	}
	
	public Student getLatestStudent(int id) {
		return studentMapper.selectLatestStudent(id);
	}
}
