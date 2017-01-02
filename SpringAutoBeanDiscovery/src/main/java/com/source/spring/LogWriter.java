package com.source.spring;

import org.springframework.stereotype.Component;

@Component
public class LogWriter implements ILogWriter {


	public void write(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
	}

}
