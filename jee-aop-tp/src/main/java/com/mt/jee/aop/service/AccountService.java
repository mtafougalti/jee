package com.mt.jee.aop.service;

import com.mt.jee.aop.dao.AccountDao;
import com.mt.jee.aop.model.Account;

public class AccountService {
	
	private AccountDao accountDao;
	
	public AccountService(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void withdraw(Account account, double amount) {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		account.setBalance(account.getBalance()-amount);
	}
	
	public void pay(Account account, double amount) { 
		account.setBalance(account.getBalance()+amount);
	}
	
	public void addNewAccount(int code, double balance) {
		accountDao.saveAccount(new Account(code, balance));
	}
	
	public Account getAccount(int code) {
		return accountDao.getAccount(code);
	}

}
