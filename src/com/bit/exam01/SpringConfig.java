package com.bit.exam01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bit.dao.GoodsDao;
import com.bit.dao.MemberDao;

/*
 * beans.xml을 대신하는 class -> MainTest2.java에서 테스트하면 됨
 */


@Configuration
public class SpringConfig {
					 
	@Bean 			//ID(메소드이름)
	public MemberDao mDao() {
		return new MemberDao();
	}
	
	@Bean 
	public GoodsDao gDao() {
		return new GoodsDao();
	}
}
