package com.goodteam.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advice for logging

	// start with @Befor advice

//	@Before("execution(public void add*())")
	@Before("execution(* com.goodteam.aop.dao.*.*(..))")
	public void beforAddAccountAdvice() {

		System.out.println("\n======>>> Executing @Before advice on addAccount()");
	}
}
