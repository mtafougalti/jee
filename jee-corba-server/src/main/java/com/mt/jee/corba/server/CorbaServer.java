package com.mt.jee.corba.server;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import AdditionApp.Addition;
import AdditionApp.AdditionHelper;

public class CorbaServer {

	public static void main(String[] args) {
		try {
			// create and initialize the ORB
			ORB orb = ORB.init(args, null);
			// Get the reference rootPOA
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			// Activate the rootPOA
			rootpoa.the_POAManager().activate();

			// Create the servant
			AdditionService additionService = new AdditionService();

			// get object reference from the servant
			org.omg.CORBA.Object additionServiceRef = rootpoa.servant_to_reference(additionService);
			Addition additionServiceFinalRef = AdditionHelper.narrow(additionServiceRef);

			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			NameComponent path[] = ncRef.to_name("AdditionService");
			ncRef.rebind(path, additionServiceFinalRef);
			System.out.println("Addition Server ready and waiting ...");
			orb.run();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
