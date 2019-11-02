package com.mt.jee.services;

import com.mt.jee.ioc.dao.PersonDao;

public class PersonServiceImpl implements PersonService {

	private PersonDao personDao;

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public String getPersonInfos() {
		return personDao.getPerson().toString();
	}
	
	
}
