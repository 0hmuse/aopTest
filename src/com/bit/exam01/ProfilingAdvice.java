package com.bit.exam01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;



public class ProfilingAdvice {
	
	//afterAdvice
	public void after(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName + "�� ������ �� �Դϴ�.");
	}
	
	public void afterReturning(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName + "�� ����Ϸ� �� �� �Դϴ�.");
	}
	
	public void afterThrowing(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName + "�� ������������ �����Ͽ����ϴ�.");
	}
	
	
	
	//beforeAdvice
//	public void before() {
//		System.out.println("Ÿ�꿡�Ǵ� �޼ҵ� �����ϱ� ���Դϴ�.");
//	}
	
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toLongString();
		System.out.println(methodName + "�� �����ϱ� ���Դϴ�.");
	}
	
	
	
	//aroundAdvice
	public Object pro(ProceedingJoinPoint joinPoint) {
		Object re = null;
		
		String metodName = joinPoint.getSignature().toShortString();
		System.out.println(metodName+"����");
		long start = System.currentTimeMillis();
		//�ٽɸ޼ҵ� �ϱ���
		
		try {			
			re = joinPoint.proceed();
			//Ÿ���� �Ǵ� �޼ҵ� ȣ��, �갡 �����ϱ� �� �� �� �ٽɸ޼ҵ带 ȣ������			
		}catch (Throwable e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}		
		
		System.out.println(metodName+"����");
		long finish = System.currentTimeMillis();
		System.out.println("�ɸ��ð�: " + (finish - start));
		
		return re;
	}
}
