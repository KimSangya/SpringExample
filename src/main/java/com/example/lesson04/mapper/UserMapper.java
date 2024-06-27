package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson04.domain.User;

@Mapper
public interface UserMapper {
	public int insertUser(
			@Param("name") String name, 
			@Param("yyyymmdd") String yyyymmdd, 
			@Param("email") String email, 
			@Param("introduce") String introduce);
	
	public User selectLatestUser();
	
	public boolean isDuplicationByName(String name); // 이친구는 다른 애 이기 때문에 특수한 쿼리라서 이상하게 짓는것이다.
}
