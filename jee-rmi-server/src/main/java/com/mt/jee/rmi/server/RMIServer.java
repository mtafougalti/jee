package com.mt.jee.rmi.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import com.mt.jee.rmi.objects.HelloWorld;
import com.mt.jee.rmi.objects.HelloWorldImpl;

public class RMIServer {

	public static void main(String[] args) {
		
		try {
			LocateRegistry.createRegistry(1099);
			//Registry registry = LocateRegistry.getRegistry("localhost", 1099);
			HelloWorld hw = new HelloWorldImpl();
			String url = "rmi://localhost:1099/helloWorld";
			Naming.rebind("helloWorld", hw);
			System.out.println("Server Started");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
