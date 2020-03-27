package com.bit.dao;

import java.util.ArrayList;

public class MemberDao {
	public int insertMemner(String name, int age) {
		System.out.println("회원등록 성공!");
		return 1;
	}
	
	public void updateMember() {
		System.out.println("회원수정 완료!");
	}
	
	public ArrayList<String> listMember(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("이순신");
		list.add("유관순");
		list.add("김유신");
		return list;
	}
}
