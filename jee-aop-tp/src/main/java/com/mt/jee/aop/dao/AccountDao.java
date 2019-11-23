package com.mt.jee.aop.dao;

import com.mt.jee.aop.model.Account;

public interface AccountDao {
	
	public Account getAccount(int code);
	
	public void saveAccount(Account acount);

}
