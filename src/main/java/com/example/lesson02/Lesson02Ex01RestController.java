package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.domain.UsedGoods;

@RestController // @Controller + @Responsebody (JSON을 담기 위해 사용)
public class Lesson02Ex01RestController {
	
	@Autowired
	private UsedGoodsBO usedGoodsBO; // DI : 스프링 빈을 주입시키는 것. BO에서 객체를 가져와 주입을 시키는것
	
	//http:localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01") // 1
	public List<UsedGoods> ex01() { // 메소드 수행
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList(); // 커서를 대고 F3번
		return usedGoodsList; // list -> Response JSON String
	}
}
