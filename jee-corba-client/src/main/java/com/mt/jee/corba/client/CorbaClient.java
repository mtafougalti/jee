package com.mt.jee.corba.client;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import AdditionApp.Addition;
import AdditionApp.AdditionHelper;

public class CorbaClient {

	public static void main(String[] args) {
		try {
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object objRef =   orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			Addition addition = (Addition) AdditionHelper.narrow(ncRef.resolve_str("AdditionService"));
			System.out.println(addition.add(5, 10));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
 
	}

}
