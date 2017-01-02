package com.source.spring;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Logger {
	
		//@Inject	
		@Autowired
		//@Named(value="consolewriter")
		private ILogWriter consoleWriter;
	
		//@Inject
		@Autowired
		private ILogWriter logWriter;

	/*	@Inject
		@Named(value="consolewriter")
		public void setConsoleWriter(ILogWriter consoleWriter) {
			this.consoleWriter = consoleWriter;
		}

		//@Inject
		public void setLogWriter(ILogWriter logWriter) {
			this.logWriter = logWriter;
		}*/
		
		public void writeConsoleWriter(){
			consoleWriter.write("Console writer");
		}
		
		public void writeLogWriter(){
			logWriter.write("Log writer");
		}
		
}
