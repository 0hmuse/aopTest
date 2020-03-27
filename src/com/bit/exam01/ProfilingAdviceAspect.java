package com.bit.exam01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
public class ProfilingAdviceAspect {
	
					//모든 파일 com.bit.dao에 모든파일 모든메소드(매개변수 유무 수랑 상관없이)
	@Pointcut("execution(public * com.bit.dao..*(..))")
	private void daoMethod() {}
		
	
	//aroundAdvice("타깃이 되는 경로(애들)를 가진 아이디")
	//AroundAdvice는 매개변수(joinPoint)를 가진다!!
	@Around("daoMethod()")
	public Object pro(ProceedingJoinPoint joinPoint) {
		Object re = null;
		
		String metodName = joinPoint.getSignature().toShortString();
		System.out.println(metodName+"시작");
		long start = System.currentTimeMillis();
		//핵심메소드 하기전
		
		try {			
			re = joinPoint.proceed();
			//타겟이 되는 메소드 호출, 얘가 시작하기 전 후 에 핵심메소드를 호출해줌			
		}catch (Throwable e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}		
		
		System.out.println(metodName+"종료");
		long finish = System.currentTimeMillis();
		System.out.println("걸린시간: " + (finish - start));
		
		return re;
	}
}
