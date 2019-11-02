package com.mt.jee.ioc;

import com.mt.jee.ioc.dao.PersonDaoImpl;
import com.mt.jee.services.PersonServiceImpl;

public class Application {
	
	public static void main(String[] args) {
		PersonDaoImpl personDao = new PersonDaoImpl();
		PersonServiceImpl personService = new PersonServiceImpl();
		personService.setPersonDao(personDao);
		System.out.println(personService.getPersonInfos());
	}

}
