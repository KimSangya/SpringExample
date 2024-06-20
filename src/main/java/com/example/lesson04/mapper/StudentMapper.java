package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson04.domain.Student;

@Mapper
public interface StudentMapper {
	
	// 객체를 사용할수도 있으니, int로 리턴 타입으로 작성한다.
	public int insertStudent(Student studnet);
	
	public Student selectLatestStudent(int id);
}
