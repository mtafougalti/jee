package com.mt.jee.ioc.dao;

import com.mt.jee.ioc.model.Person;

public class PersonDaoImpl implements PersonDao {

	@Override
	public Person getPerson() {
		return new Person("John", "Smith");
	}

}
