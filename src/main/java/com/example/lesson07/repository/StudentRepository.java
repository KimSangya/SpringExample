package com.example.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> { // mapper를 따로 붙이지 않아도 괜찮음. JpaRepository extends를 해줘야함. Studententity, Integer
	
	// Spring Data JPA vs 순수 JPA
	// public StudentEntity save(StudentEntity student) 이런걸 안해도 알아서 구현이 된다는것이죠.

}
