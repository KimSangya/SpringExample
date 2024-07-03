package com.example.lesson04.bo;

import java.time.LocalDateTime;
import java.util.Optional;

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
	
	// update
	// input : 변경할 id, 변경할 dreamJob
	// output : StudentEntity or Null(업데이트 대상이 없을때)
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// 기존 데이터를 조회 => StudentEntity
		// Type mismatch: cannot convert from Optional<StudentEntity> to StudentEntity Optional : null일수도 있는 객체를 넣어주는것이고, StudentEntity와는 다른 객체이다.
		// orelse(null)를 넣어줌으로써 해결
		StudentEntity student = studentRepository.findById(id).orElse(null); 
		
		
		
//		student.builder()
//		.dreamJob(dreamJob)
//		.build(); // 이친구는 안됨. 가져온 친구에서 new를 해주는거라 적용이 되지 않음.
		
		// 엔티티의 데이터 값을 변경할 형태로 만든다
		if(student != null) {
			student = student.toBuilder() // toBuilder는 기존 필드 값은 유지하고 일부만 변경한다.
					.dreamJob(dreamJob) // 교체 대상
					.build(); // 이렇게 사용해야한다. 꼭 객체에 저장
			
			// update
			// save 요청
			student = studentRepository.save(student);
		}
		// 마지막 리턴 null이 아닐때는 채워서 리턴을 해준다. 다만 null이 리턴 되면 따로 업데이트를 안해준다. 
		return student;
		
	}
	
	public Student getLatestStudent(int id) {
		return studentMapper.selectLatestStudent(id);
	}
	
	/// input : id
	// output : X
	public void deleteStudentById(int id) {
		// 방법 1번째 : 이렇게 사용하면 Optional를 사용할 필요가 없다. 개인 프로젝트를 할때는 Optional로 사용해야한다.
//		StudentEntity student = studentRepository.findById(id).orElse(null); // 조회할 친구를 id값으로 가져옴
//		if(student != null) {
//			studentRepository.delete(student);
//		}
		
		// 방법 2번째 : 권장
		Optional<StudentEntity> studentOptional = studentRepository.findById(id); // 이친구의 원래 객체는 optional이었고, 이걸 넣어야 올바르게 넣어지는것이다.
		// 람다식 개인프로젝트 진행하실때, 몇분간 안배웠던것들을 알려줄건데, 람다식으로 알려줄것임. 중요한 객체를 s라고 집어넣고, -> : 삭제 해달라고 할것이다.
		// if문을 쓰지 않더라도, 이친구는 NPE(NullpointerException)가 발생하지 않게 해준다.
		studentOptional.ifPresent(s -> studentRepository.delete(s)); 
		
	}
}
