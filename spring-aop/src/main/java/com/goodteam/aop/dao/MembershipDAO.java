package com.goodteam.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addWiseMember() {
		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
		return true;
	}

	public void wakeUp() {
		System.out.println(getClass() + ": I'm wakeing up now");

	}
}
