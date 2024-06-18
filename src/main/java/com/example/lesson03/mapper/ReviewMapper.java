package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson03.domain.Review;

@Mapper // 이친구가 붙어야 매퍼구나, 이친구와 연결되어있는 xml 구조를 찾아야겠다를 알수있다.
public interface ReviewMapper {
	
	 // input : id output : Review or null
	public Review selectReviewById(int id);
	public int insertReview(Review review);
	
	// param : 하나의 맵으로 xml에 전송
	public int insertReviewAsField(
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);
	
	public int updateReviewById(
			@Param("id") int id, 
			@Param("review") String review);
	
	public int deleteReviewById(
			@Param("id") int id);
}

