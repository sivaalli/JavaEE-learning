package com.source.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger { 

	@Pointcut("args(name,num)")
	public void cameraSnap(String name, double num) {
		// inside of this method is not invoked anytime
	}

	// @Before("execution(void com.source.spring.aop.Camera.snap())")
	@Before("cameraSnap(name,num)")
	public void aboutToTakePhoto(String name,double num) {
		System.out.println(name);
		System.out.println(num);
	}

}
