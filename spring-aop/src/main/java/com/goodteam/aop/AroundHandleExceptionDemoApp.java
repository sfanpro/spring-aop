package com.goodteam.aop;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.goodteam.aop.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {

		// read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundDemoApp");
		myLogger.info("Calling getFourtune");

		boolean tripWire = true;
		String data = theFortuneService.getFotrune(tripWire);
		myLogger.info("\nMy fortune is: " + data);
		myLogger.info("Finished");

		context.close();
	}
}
