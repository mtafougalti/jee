package com.mt.jee.corba.server;

import AdditionApp.AdditionPOA;

public class AdditionService extends AdditionPOA {

	@Override
	public int add(int a, int b) {
		return a+b;
	}

}
