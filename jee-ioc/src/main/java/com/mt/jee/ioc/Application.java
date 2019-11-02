package com.mt.jee.ioc;

import com.mt.jee.services.PersonService;

public class Application {
	
	public static void main(String[] args) {
		BeansContext context = new BeansContext();
		context.init();
		PersonService personService = (PersonService) context.getBean("personService");
		System.out.println(personService.getPersonInfos());
        
	}

}
