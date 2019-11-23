package com.mt.jee.aop.aspects;

import java.util.Scanner;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecurityAspect {
	
	@Pointcut("execution(* *..Application.main(..))")
	public void login() {}
	
	@Before("login()")
	public void before() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Login : " );
		String login = scanner.next();
		System.out.print("Password : " );
		String pw = scanner.next();
		
		if(login.equals("admin") && pw.equals("test")) {
			System.out.println("Welcome to your Account ... ");
		} else {
			System.err.println("Login or Password incorrect !");
			System.exit(1);
		}
		
	}

}
