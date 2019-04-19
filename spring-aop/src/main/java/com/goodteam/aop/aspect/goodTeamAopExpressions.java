package com.goodteam.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class goodTeamAopExpressions {
	@Pointcut("execution(* com.goodteam.aop.dao.*.*(..))")
	public void forDaoPackage() {
	}

	// create pointcut for getter method
	@Pointcut("execution(* com.goodteam.aop.dao.*.get*(..))")
	public void getter() {
	}

	// create pointcut for setter method
	@Pointcut("execution(* com.goodteam.aop.dao.*.set*(..))")
	public void setter() {
	}

	// create point: include package... exclude getter/setter methods
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
	}
}
