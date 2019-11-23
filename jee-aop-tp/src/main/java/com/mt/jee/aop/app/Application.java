package com.mt.jee.aop.app;

import com.mt.jee.aop.dao.AccountDao;
import com.mt.jee.aop.dao.AccountDaoImpl;
import com.mt.jee.aop.model.Account;
import com.mt.jee.aop.service.AccountService;

public class Application {
	public static void main(String[] args) {
		AccountService service = new AccountService((AccountDao) new AccountDaoImpl());
		service.addNewAccount(1, 0);
		service.addNewAccount(2, 0);

		Account account1 = service.getAccount(1);
		service.pay(account1, 20000);
		try {
			service.withdraw(account1, 13000);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println(account1.toString());
		}
	}
}
