package com.example.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson02.domain.UsedGoods;

@Mapper // 스프링에서 지원을 해주는게 아니고, mybatis에서 제공해주는.
public interface UsedGoodsMapper {
	
	// input : (BO로부터 받아옴) X
	// output : (BO한테 전달)List<UsedGoods>
	public List<UsedGoods> selectUsedGoods();
}
