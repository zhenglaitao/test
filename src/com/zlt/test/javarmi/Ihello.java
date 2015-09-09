package com.zlt.test.javarmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Ihello extends Remote{

	public void sayhello(String name) throws RemoteException;
}
