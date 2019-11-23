package com.mt.jee.aop.aspects;

public aspect FirstAspect {
	//pointcut mainMethod() : execution(public static void main(String[]));
	pointcut mainMethod() : execution(* *..Application.main(..));
	
	before() : mainMethod() {
		System.out.println("Avant Main execution");
	}
	
	after() : mainMethod() {
		System.out.println("After Main execution");
	}
}
