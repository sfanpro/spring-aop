package com.goodteam.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	// this is where we add all of our related advice for logging

	// start with @Befor advice

	// declare pointcut declaration
	@Pointcut("execution(* com.goodteam.aop.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// create pointcut for getter method
	@Pointcut("execution(* com.goodteam.aop.dao.*.get*(..))")
	private void getter() {
	}

	// create pointcut for setter method
	@Pointcut("execution(* com.goodteam.aop.dao.*.set*(..))")
	private void setter() {
	}

	// create point: include package... exclude getter/setter methods
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {
	}

	@Before("com.goodteam.aop.aspect.goodTeamAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforAddAccountAdvice() {
		System.out.println("\n======>>> Executing @Before advice on addAccount()");
	}
}
