package com.kh.aop.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/*
 * - Aspect : �ش� Ŭ������ Aspect(aop��ü)��� ���� ����
 * - Component : Spring�� �ش� ���� ��Ī�� �� �ֵ��� ���� (Bean���)
 */

@Slf4j
@Aspect
@Component
public class LoggingAOP {
	
	/*
	 * <����>
	 * @Before : ���޼��� ���� ���� Advice(�߰����)�� ����ȴ�.
	 * 
	 * @After : ���޼��� ���� �Ŀ� Advice(�߰����)�� ����ȴ�.
	 * 
	 * @AfterReturning : ��� �޼��尡 ���������� ��ȯ�� �Ŀ� dvice(�߰����)�� ����ȴ�.
	 * 
	 * @AfterThrowing : ��� �޼��尡 ���ܸ� ���� �Ŀ� Advice(�߰����)�� ����ȴ�.
	 * 
	 * @Around : ���޼��带 ���μ� �޼��� ȣ�� ���Ŀ� Advice�� ������ �� �ִ�.
	 */
	
	/*
	 * <���>
	 * target : Ư�� �������̽��� �� �ڽ�Ŭ����
	 * within : Ư�� ��Ű�� �Ǵ� Ŭ����
	 * execut
	 */
	
	//Ư�� �޼��峪 ��Ű������ join point
	//com.kh�Ʒ� ��� controller��Ű�� ���� Ŭ������ ��� �޼��忡 ���� �����ϰڴٰ� ���� ����.
	@Pointcut("execution(* com.kh.etc.aoptest.*.*(..) )")
	private void cut() {};
	
	//cut�޼��尡 ����Ǵ� ���� ������ before()�޼��带 ����
	//JoinPoint : pointcut������ ���� ������ ����ִ�.
	//�޼����� ������ ���� �Ϲ����� joinpoint��
	@Before("cut()")
	public void before(JoinPoint joinPoint) {
		
		//����Ǵ� �޼����� �̸��� ��������
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		
		Object[] args = joinPoint.getArgs();
		
		log.info("==================== START ====================");
		log.info("-------------------- API Controller --------------------");
		log.info("Information		: " + methodSignature);
		log.info("Method Name		: " + method);
		log.info("Parameter			: " + Arrays.toString(args));
	}
	
	@AfterReturning(value="cut()", returning= "obj")
	public void afterReturn(JoinPoint joinPoint, Object obj) {
		log.info("====================  END  ====================");
		log.info("Object	: " + obj);
	}
	
	//api�ð�����
	@Around("cut()")
	public Object displayLogInfo(ProceedingJoinPoint joinPoint) throws Throwable {
		//������ ���� �ð�
		long start = System.currentTimeMillis(); // 0
		
		//�����Ϸ��� joinpoint�޼��� ����
		Object result = joinPoint.proceed(); //���� �������̴� �۾� ����
		
		//������ ���� �ð�
		long end = System.currentTimeMillis(); // 1000
		
		long runTime = end - start; //����ð�
		
		log.info("------------------------------");
		log.info("Information		: " + joinPoint.getSignature());
		log.info("Processing Time   : " + runTime + "ms");
		
		return result;
	}
	
}
