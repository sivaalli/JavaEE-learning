package com.source.spring;

public class ConsoleWriter implements ILogWriter{

	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}

	public void write() {
		// TODO Auto-generated method stub
		System.out.println(message);
	}

}
