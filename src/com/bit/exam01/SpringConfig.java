package com.bit.exam01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.bit.dao.GoodsDao;
import com.bit.dao.MemberDao;

/*
 * beans.xml을 대신하는 class -> MainTest2.java에서 테스트하면 됨
 * xml사용 안하고 싶으면~
 */


@Configuration
@EnableAspectJAutoProxy //xml에서 autoperoxy를 사용하여 객체 만들어주는걸 대신해줌
public class SpringConfig {
	
	@Bean
	public ProfilingAdviceAspect advice() {
		return new ProfilingAdviceAspect();
	}	
					 
	@Bean 			//ID(메소드이름)
	public MemberDao mDao() {
		return new MemberDao();
	}
	
	@Bean 
	public GoodsDao gDao() {
		return new GoodsDao();
	}
}
