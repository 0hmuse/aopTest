package com.bit.dao;

import java.util.ArrayList;

public class GoodsDao {

	public int insertGoods(String item, int price) {
		System.out.println("상품을 등록했습니다.");
		return 1;
	}
	
	public ArrayList<String> listGoods(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("사과");
		list.add("포도");
		list.add("복숭아");
		//System.out.println(list.get(100));
		return list;
	}
}
