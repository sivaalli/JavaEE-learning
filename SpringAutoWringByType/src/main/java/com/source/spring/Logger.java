package com.source.spring;

public class Logger {
		private ILogWriter consoleWriter;
		private ILogWriter logWriter;
		
		

		public Logger(ConsoleWriter consoleWriter, LogWriter logWriter) {	
			this.consoleWriter = consoleWriter;
			this.logWriter = logWriter;
		}

		public void setConsoleWriter(ILogWriter consoleWriter) {
			this.consoleWriter = consoleWriter;
		}

		public void setLogWriter(ILogWriter logWriter) {
			this.logWriter = logWriter;
		}
		
		public void writeConsoleWriter(){
			consoleWriter.write();
		}
		
		public void writeLogWriter(){
			logWriter.write();
		}
		
}
