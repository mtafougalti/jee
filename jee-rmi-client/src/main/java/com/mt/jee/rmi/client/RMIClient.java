package com.mt.jee.rmi.client;

import java.rmi.Naming;

import com.mt.jee.rmi.objects.HelloWorld;

public class RMIClient {

	public static void main(String[] args) {
		
		try {
			HelloWorld hw = (HelloWorld) Naming.lookup("rmi://localhost:1099/helloWorld");
			System.out.println(hw.sayHello());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
