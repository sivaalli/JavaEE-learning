package com.source.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
	
	@DeclareParents(value="com.source.spring.aop.*",  defaultImpl=com.source.spring.aop.Camera.class)
	private ICamera Icamera;
	
	@Pointcut("within(com.source.spring.aop.*)")
	public void snap(){
		
	}
	
	@Around("snap()")
	public void takeSnap(ProceedingJoinPoint jp){
		System.out.println("Around Before!!!!!!!!!!!!!!!");
		try {
			jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Around After!!!!!!!!!!!!!!!!");
	}
}
