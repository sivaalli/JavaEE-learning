package com.source.spring;

import org.springframework.stereotype.Component;


//Not needed to actually name component, just for demostration
@Component//("consolewriter")
public class ConsoleWriter implements ILogWriter{

	public void write(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
	}

}
