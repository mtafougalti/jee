package com.mt.jee.aop.aspects;

import java.util.HashMap;
import java.util.Map;

import com.mt.jee.aop.model.Account;

public aspect IntroductionAspect {
	declare parents : com.mt.jee.aop.dao.AccountDaoImpl implements com.mt.jee.aop.dao.AccountDao;

	private Map<Integer, Account> com.mt.jee.aop.dao.AccountDaoImpl.accountMap = new HashMap<>();
	
	public Account com.mt.jee.aop.dao.AccountDaoImpl.getAccount(int code){
		return accountMap.get(code);
	}
	
	public void com.mt.jee.aop.dao.AccountDaoImpl.saveAccount(Account account){
		accountMap.put(account.getCode(), account);
	}
}
