package com.mt.jee.rmi.objects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloWorldImpl extends UnicastRemoteObject implements HelloWorld {

	private static final long serialVersionUID = -921780619412057517L;

	public HelloWorldImpl() throws RemoteException {
	}

	@Override
	public String sayHello() throws RemoteException {
		return "Hello World ! ";
	}

}
