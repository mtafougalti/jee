package com.mt.jee.aop.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecondAspect {

	@Pointcut("execution(* *..Client.main(..))")
	public void log() {
	}

	@Before("log()")
	public void before() {
		System.out.println("Before Main Execution");
	}

	@After("log()")
	public void after() {
		System.out.println("After Main Execution");
	}

}
