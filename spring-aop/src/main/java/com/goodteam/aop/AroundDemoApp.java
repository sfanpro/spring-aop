package com.goodteam.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.goodteam.aop.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\nMain Program: AroundDemoApp");
		System.out.println("Calling getFourtune");
		String data = theFortuneService.getFotrune();
		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished");

		context.close();

	}
}
