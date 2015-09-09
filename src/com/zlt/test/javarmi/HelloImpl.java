package com.zlt.test.javarmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Ihello{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1595037125628331701L;

	public HelloImpl() throws RemoteException {
		super();
	}

	@Override
	public void sayhello(String name) {
		System.out.println("hello: "+name);
	}

}
