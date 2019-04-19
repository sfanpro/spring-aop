package com.goodteam.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.goodteam.aop.dao.AccountDAO;
import com.goodteam.aop.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// get membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call accountDAO get/set method
		theAccountDAO.setName("newName");
		theAccountDAO.setServiceCode("gold");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call membership business method
		theMembershipDAO.addWiseMember();
		theMembershipDAO.wakeUp();

		// do it again!
//		System.out.println("\n let's call it again!\n");

		// call the business method again
//		theAccountDAO.addAccount();

		// close the context
		context.close();

	}
}
