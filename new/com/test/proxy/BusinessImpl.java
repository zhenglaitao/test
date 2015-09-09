package com.test.proxy;

public class BusinessImpl implements Business {

	@Override
	public void doAction() {
		System.out.println("BusinessImpl doAction go!");
	}

	@Override
	public void doAction2() {
		System.out.println("BusinessImpl doAction222222 go!");
	}

}
