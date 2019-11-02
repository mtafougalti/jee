package com.mt.jee.ioc;

import java.lang.reflect.Method;
import java.util.Properties;

import com.mt.jee.ioc.dao.PersonDao;
import com.mt.jee.ioc.dao.PersonDaoImpl;
import com.mt.jee.services.PersonService;
import com.mt.jee.services.PersonServiceImpl;

public class Application {
	
	public static void main(String[] args) {
		Properties prop = Configuration.loadProperties();
        // get the property value and print it out
        System.out.println(prop.getProperty("personDao"));
        System.out.println(prop.getProperty("personService"));
        
        try {
			Class<? extends Object> personDaoClass = Class.forName(prop.getProperty("personDao"));
			PersonDao personDao = (PersonDao) personDaoClass.newInstance();
			
			Class<? extends Object> personServiceClass = Class.forName(prop.getProperty("personService"));
			PersonService personService = (PersonService) personServiceClass.newInstance();
			Method setPersonDaoMethod = personServiceClass.getMethod("setPersonDao", new Class[] {PersonDao.class});
			setPersonDaoMethod.invoke(personService, new Object[] {personDao});
			
			System.out.println(personService.getPersonInfos());
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}

}
