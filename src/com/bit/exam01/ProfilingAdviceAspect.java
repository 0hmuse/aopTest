package com.bit.exam01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
public class ProfilingAdviceAspect {
	
					//��� ���� com.bit.dao�� ������� ���޼ҵ�(�Ű����� ���� ���� �������)
	@Pointcut("execution(public * com.bit.dao..*(..))")
	private void daoMethod() {}
		
	
	//aroundAdvice("Ÿ���� �Ǵ� ���(�ֵ�)�� ���� ���̵�")
	//AroundAdvice�� �Ű�����(joinPoint)�� ������!!
	@Around("daoMethod()")
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
