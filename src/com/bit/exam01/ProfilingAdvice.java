package com.bit.exam01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;



public class ProfilingAdvice {
	
	//afterAdvice
	public void after(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName + "이 동작한 후 입니다.");
	}
	
	public void afterReturning(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName + "가 정상완료 한 후 입니다.");
	}
	
	public void afterThrowing(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName + "가 비정상적으로 종료하였습니다.");
	}
	
	
	
	//beforeAdvice
//	public void before() {
//		System.out.println("타깃에되는 메소드 실행하기 전입니다.");
//	}
	
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toLongString();
		System.out.println(methodName + "이 실행하기 전입니다.");
	}
	
	
	
	//aroundAdvice
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
