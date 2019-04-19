package com.goodteam.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advice for logging

	// start with @Befor advice

	// declare pointcut declaration
	@Pointcut("execution(* com.goodteam.aop.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Before("forDaoPackage()")
	public void beforAddAccountAdvice() {
		System.out.println("\n======>>> Executing @Before advice on addAccount()");
	}

	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n======>>> Performing API analytics");
	}
}
