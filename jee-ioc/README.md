# JEE IOC (Dependency Injection)
-First Version : 
	public static void main(String[] args) {
		PersonDaoImpl personDao = new PersonDaoImpl();
		PersonServiceImpl personService = new PersonServiceImpl();
		personService.setPersonDao(personDao);
		System.out.println(personService.getPersonInfos());
	}