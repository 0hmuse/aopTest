package com.bit.exam01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.bit.dao.GoodsDao;
import com.bit.dao.MemberDao;

/*
 * beans.xml�� ����ϴ� class -> MainTest2.java���� �׽�Ʈ�ϸ� ��
 * xml��� ���ϰ� ������~
 */


@Configuration
@EnableAspectJAutoProxy //xml���� autoperoxy�� ����Ͽ� ��ü ������ִ°� �������
public class SpringConfig {
	
	@Bean
	public ProfilingAdviceAspect advice() {
		return new ProfilingAdviceAspect();
	}	
					 
	@Bean 			//ID(�޼ҵ��̸�)
	public MemberDao mDao() {
		return new MemberDao();
	}
	
	@Bean 
	public GoodsDao gDao() {
		return new GoodsDao();
	}
}
