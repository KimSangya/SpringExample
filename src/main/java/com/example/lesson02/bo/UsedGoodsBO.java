package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service // spring bean
public class UsedGoodsBO {
	
	// 필드 정의 부분, spring bean을 Autowired를 통해서 가져온다.
	@Autowired // Dependency Injection(DI), 면접 문제로 많이 나온다. : 의존성 주입, 
	private UsedGoodsMapper usedGoodsMapper; // 객체의 이름은 소문자로
	
	// input : x (컨트롤러로 부터 들어온 요청)
	// output : (Repository한테 받은 것들) List<UsedGoods> (컨트롤러한테 줌)
	public List<UsedGoods> getUsedGoodsList() {
//		List<UsedGoods> usedGoodsList = usedGoodsMapper.selectUsedGoods();
//		return usedGoodsList;
		return usedGoodsMapper.selectUsedGoods(); // 컨트롤러한테 반환을 시킨다.
	}
}
