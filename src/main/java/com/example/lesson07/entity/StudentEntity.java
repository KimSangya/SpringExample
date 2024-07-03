package com.example.lesson07.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString // 객체 출력시 필드 값들이 보인다.
@AllArgsConstructor // 모든 파라미터가 있는 생성자이다.
@NoArgsConstructor // 파라미터가 없는 생성자
@Builder(toBuilder = true) // setter를 대신해서 내용을 담음, toBuilder = true : 필드 수정을 허용하겠다라는 의미
@Getter
@Table(name = "new_student")
@Entity// 이 객체는 엔티티다. bo_jpa -db
public class StudentEntity {
	@Id // pk 식별자 등록
	@GeneratedValue(strategy = GenerationType.IDENTITY) // insert시 방금 들어간 id를 가져오기
	private int id; // used generated를 대신해주는 어노테이션이 있다.
	
	private String name;
	
	// 카멜로 되어있는 애들만 붙여줘야한다.
	@Column(name = "phonenumber")
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamjob")
	private String dreamJob;
	
	@CreationTimestamp // 시간값이 없어도 현재 시간으로 들어감. update시 바뀌지 않음.
	@Column(name = "createdAt")
	private LocalDateTime createdAt; // null이면 추가하는데, 업데이트떄는 추가 안하겠다.
	
	@UpdateTimestamp // update시 시간 변경됨
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
}
