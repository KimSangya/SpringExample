package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lesson07.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> { // mapper를 따로 붙이지 않아도 괜찮음. JpaRepository extends를 해줘야함. Studententity, Integer
	
	// Spring Data JPA vs 순수 JPA
	// public StudentEntity save(StudentEntity student) 이런걸 안해도 알아서 구현이 된다는것이죠.
	// public StudentEntity findById(int id) // Id를 가지고 조회 -> JpaRepository에서 있으니 굳이 안만들어도 된다.
	// public void delete(StudentEntity student) // 이친구의 엔티티를 가져와서 이친구의 객체를 조회 가능.
	public List<StudentEntity> findAll(); // 모든 친구들을 다 찾는 쿼리문
	
	// ex02/select1 -> JPQL문법
	// 2
	public List<StudentEntity> findAllByOrderByIdDesc(); // 이름 틀리면 사용이 불가함으로 조심해야함.
	
	// 3
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	
	// 4
	public List<StudentEntity> findByName(String name); // 변수 명은 상관은 없고, 필드 명이 중요함.
	
	// 5
	public List<StudentEntity> findByNameIn(List<String> names); // 리스트로 내려오는 친구에 따라서 설정. 
	
	// 6
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob); // 리스트로 내려오는 친구에 따라서 설정. 내가 적은 순서대로 매핑이 된다.
	
	// 7
	public List<StudentEntity> findByEmailContains(String keyword);
	
	// 8
	public List<StudentEntity> findByNameStartingWith(String name);
	
	// 9
	public List<StudentEntity> findByIdBetween(int startId, int endId);
	
	// 다른 방식
	// ex02/2 - native query 내가 시키는 쿼리를 직접해! 라는 말
	// @Query(value = "select * from `new_student` where `dreamJob` = :dreamJob", nativeQuery = true) // nativeQuery = true => DB에 직접 SQL 쿼리 수행
	
	// ex02/2-1 - JPQL(엔티티 조회) 형식은 native query랑 비슷해지는데, JPQL로 사용. : SQL query 아님!
	@Query(value = "select s from StudentEntity s where s.dreamJob = :dreamJob") // nativeQuery = false / value에 쿼리를 작성하는데, 엔티티로 조회를 하는것 s : 엔티티의 별칭을 설정
	// native 문법과는 다른 문법이다.
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob); // 파라미터의 어노테이션을 붙어줘야한다.
	
}
