package com.mt.jee.aop.aspects;

public aspect LoggerAspect {
	
	private long t1, t2;
	
	pointcut log() : call(* *..ccountService.*(..)) || initialization(*..ccountService.new(..));
	
	before() : log() {
		System.out.println("Before Execution of methode " + thisJoinPoint.getSignature());
		t1 = System.currentTimeMillis();
	}
	
	after() : log() {
		System.out.println("After Execution of methode " + thisJoinPoint.getSignature());
		t2 = System.currentTimeMillis();
		System.out.println("Execution Duration : " + (t2-t1));
	}
	
}
