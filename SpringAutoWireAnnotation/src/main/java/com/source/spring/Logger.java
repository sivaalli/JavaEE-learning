package com.source.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class Logger {
		
	//Using annotaion based auto wiring we dont even need setter to autowire. 
	//Just autowired annotation on private attributes works
	//since annotation auto wires using type we can have any name for setter methods. Just type should match
		@Autowired
		private ConsoleWriter consoleWriter;
		
		private LogWriter logWriter;
	
		@Autowired
		public void setLogWriter2312(LogWriter logWriter) {
			this.logWriter = logWriter;
		}

		public void writeConsoleWriter(){
			consoleWriter.write();
		}
		
		public void writeLogWriter(){
			logWriter.write();
		}
		
}
