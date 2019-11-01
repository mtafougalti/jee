package com.mt.jee.rmi.objects;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloWorld extends Remote{
	public String sayHello() throws RemoteException;
}
