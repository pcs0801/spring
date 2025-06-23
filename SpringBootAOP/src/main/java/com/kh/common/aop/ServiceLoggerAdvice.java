package com.kh.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ServiceLoggerAdvice {

	/*
	 * @Before("execution(* com.kh.service.BoardDAOService*.*(..))") public void
	 * startLog(JoinPoint jp) { log.info("startLog"); log.info("startLog : " +
	 * jp.getSignature()); if (jp.getArgs() != null) { log.info("startLog : " +
	 * Arrays.toString(jp.getArgs())); } }
	 * 
	 * @After("execution(* com.kh.service.BoardDAOService*.*(..))") public void
	 * stopLog(JoinPoint jp) { log.info("stopLog"); log.info("stopLog : " +
	 * jp.getSignature()); }
	 */
}
