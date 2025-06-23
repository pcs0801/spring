package com.kh.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class TimeCheckerAdvice {
	@Around("execution(* com.kh.service.MemberDAOService*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();

		Object result = pjp.proceed();
		
		long endTime = System.currentTimeMillis();
		
		log.info(pjp.getSignature().getName() + " 작업 소요시간 : " + (endTime-startTime) + "ms");
		
		return result;
	}
}
