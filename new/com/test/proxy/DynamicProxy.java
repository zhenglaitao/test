package com.test.proxy;

/**
 * ≤‚ ‘¿‡
 * @author zlt
 *
 */
public class DynamicProxy {

	public static void main(String[] args) {
		BusinessImpl business = new BusinessImpl();
		Business busi = (Business)BusinessProxy.factory(business);
		busi.doAction();
	}
}
