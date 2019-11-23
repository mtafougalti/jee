package com.mt.jee.aop.aspects;

import com.mt.jee.aop.model.Account;

public aspect PatchAspect {
	pointcut patch(Account account, double amount) : call(* *..AccountService.withdraw(..)) && args(account, amount);
	
	void around(Account account, double amount) : patch(account, amount) {
		if(account.getBalance()>amount) {
			proceed(account, amount);
		} else {
			throw new RuntimeException("Sorry Insufficient balance !");
		}
	}
}
