package com.goodteam.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.goodteam.aop.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		// read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("---------------------------------------");
		System.out.println(theAccounts);
		System.out.println("---------------------------------------");

		context.close();

	}
}
