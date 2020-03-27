package com.bit.exam01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bit.dao.GoodsDao;
import com.bit.dao.MemberDao;

/*
 * beans.xml�� ����ϴ� class -> MainTest2.java���� �׽�Ʈ�ϸ� ��
 */


@Configuration
public class SpringConfig {
					 
	@Bean 			//ID(�޼ҵ��̸�)
	public MemberDao mDao() {
		return new MemberDao();
	}
	
	@Bean 
	public GoodsDao gDao() {
		return new GoodsDao();
	}
}
