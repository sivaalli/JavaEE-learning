package com.source;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSReceiver implements MessageListener{

	public final static String JMS_FACTORY="MyConnectionFactory";
	public final static String QUEUE="MyQueue";
	
	private QueueConnectionFactory qconFactory;
	private QueueConnection qcon;
	private QueueSession qSession;
	private QueueReceiver qReceiver;
	private Queue queue;
	
	private static boolean quit=false;
	
	public static Context getInitialContext() throws NamingException{
		Properties prop=new Properties();
		prop.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
		prop.put(Context.PROVIDER_URL, "t3://Sivapraneeth:7001");
		prop.put("java.naming.security.principal", "weblogic");
		prop.put("java.naming.security.credentials", "administrator1");
		Context ctx=new InitialContext(prop);
		return ctx;
	}
	
	public void init(Context ctx) throws NamingException, JMSException{
		qconFactory=(QueueConnectionFactory)ctx.lookup(JMS_FACTORY);
		qcon=(QueueConnection) qconFactory.createConnection();
		qSession=qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		queue=(Queue)ctx.lookup(QUEUE);
		qReceiver=qSession.createReceiver(queue);
		qReceiver.setMessageListener(this);
		qcon.start();
	}
	
	public void close() throws JMSException{
		qReceiver.close();
		qSession.close();
		qcon.close();
	}
	public static void main(String[] args) throws NamingException, JMSException, InterruptedException {
		// TODO Auto-generated method stub
		Context ctx=getInitialContext();
		JMSReceiver receiver=new JMSReceiver();
		receiver.init(ctx);
		synchronized(receiver){
			while(!quit){
				receiver.wait();	
			}
		}	
		receiver.close();
	}

	@Override
	public void onMessage(Message msg) {
		// TODO Auto-generated method stub
		String txtMessage=null;
		if(msg instanceof TextMessage){
			try {
				txtMessage=((TextMessage) msg).getText();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(txtMessage);
		synchronized(this){
			if(txtMessage.equalsIgnoreCase("quit")){
				quit=true;
				notify();
			}	
		}
		
	}
	

}
