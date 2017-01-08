package com.source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSSender {

	public final static String JMS_FACTORY="MyConnectionFactory";
	public final static String QUEUE="MyQueue";
	
	private QueueConnectionFactory qconFactory;
	private QueueConnection qcon;
	private QueueSession qSession;
	private QueueSender qSender;
	private Queue queue;
	private TextMessage textMessage;
	
	
	//get InitialCOntext to connect to JNDI/Weblogic JNDI server
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
		qSender=qSession.createSender(queue);
		textMessage=qSession.createTextMessage();
		qcon.start();
	}
	
	public void sendMessage(String msg) throws JMSException{
		textMessage.setText(msg);
		qSender.send(textMessage);
	}
	
	public void close() throws JMSException{
		qSender.close();
		qSession.close();
		qcon.close();
	}
	
	public void readAndSend(JMSSender sender) throws IOException, JMSException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String msg = null;
		System.out.println("Please type any message");
		msg=br.readLine();
		while(msg!=null){	
			sender.sendMessage(msg);
			System.out.println("Message sent");
			if(msg.equalsIgnoreCase("quit")) break;
			msg=br.readLine();	
			
		}
	}
	public static void main(String[] args) throws NamingException, JMSException, IOException {
		// TODO Auto-generated method stub
		Context ctx=getInitialContext();
		JMSSender sender=new JMSSender();
		sender.init(ctx);
		sender.readAndSend(sender);
		sender.close();
	}

}
