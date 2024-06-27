package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.domain.User;
import com.example.lesson04.mapper.UserMapper;

@Service
public class UserBO {
	
	@Autowired
	private UserMapper userMapper;
	
	// input : 파라미터 4개
	// output : X
	public void addUser(String name, String yyyymmdd, 
			String email, String introduce) {
		userMapper.insertUser(name, yyyymmdd, email, introduce);
	}
	
	// input : x
	// output : User 단 건 select 문 1개
	public User getLatestUser() {
		return userMapper.selectLatestUser();
	}
	
	// input : name
	// output : select count(*) from `new_user` where `name` = '신보람';의 갯수를 리턴 해도 괜찮다. 그래서 리턴타입을 boolean으로 할 수도 있다.
	public boolean isDuplicationByName(String name) {
		return userMapper.isDuplicationByName(name);
	}
}
