package com.goodteam.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.goodteam.aop.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	// this is where we add all of our related advice for logging

	// start with @Befor advice

	// declare pointcut declaration
//	@Pointcut("execution(* com.goodteam.aop.dao.*.*(..))")
//	private void forDaoPackage() {
//	}
//
//	// create pointcut for getter method
//	@Pointcut("execution(* com.goodteam.aop.dao.*.get*(..))")
//	private void getter() {
//	}
//
//	// create pointcut for setter method
//	@Pointcut("execution(* com.goodteam.aop.dao.*.set*(..))")
//	private void setter() {
//	}
//
//	// create point: include package... exclude getter/setter methods
//	@Pointcut("forDaoPackage() && !(getter() || setter())")
//	private void forDaoPackageNoGetterSetter() {
//	}

	@Before("com.goodteam.aop.aspect.goodTeamAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n======>>> Executing @Before advice on addAccount()");
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);

		// display method argument

		// get args
		Object[] args = theJoinPoint.getArgs();

		// loop thru args
		for (Object tempArg : args) {
			System.out.println(tempArg);

			if (tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
		}
	}
}
