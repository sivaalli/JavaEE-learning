package com.source;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class JMSSubscriber implements MessageListener{

	public final static String JMS_FACTORY="MyTopicConnectionFactory";
	public final static String TOPIC="MyTopic";
	
	private TopicConnectionFactory tconFactory;
	private TopicConnection tcon;
	private TopicSession tSession;
	private TopicSubscriber tSubscriber;
	private Topic topic;
	
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
		tconFactory=(TopicConnectionFactory)ctx.lookup(JMS_FACTORY);
		tcon=(TopicConnection) tconFactory.createConnection();
		tSession=tcon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic=(Topic)ctx.lookup(TOPIC);
		tSubscriber=(TopicSubscriber) tSession.createSubscriber(topic);
		tSubscriber.setMessageListener(this);
		tcon.start();
	}
	
	public void close() throws JMSException{
		tSubscriber.close();
		tSession.close();
		tcon.close();
	}
	
	@Override
	public void onMessage(Message msg) {
		// TODO Auto-generated method stub
		try {
			System.out.println("calling on message");
			String txtMessage=null;
			if(msg instanceof TextMessage){
				txtMessage=((TextMessage) msg).getText();		
			}
			System.out.println(txtMessage);
			synchronized(this){
				if(txtMessage.equalsIgnoreCase("quit")){
					quit=true;
					notify();
				}	
			}
		}// it is very imp to catch all exceptions because if onMessage call ends with an error
		//the acknoledgement is not send back, Server thinks that message is not delivered and causes
		//it to send same/duplicate message again. It is also imp to make onMessage implementation as
		//simple as possible. If onMessage take lot of time, server thinks message is not delivered. But we can
		//set the server acknoledgement time though
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	
	public static void main(String[] args) throws NamingException, JMSException, InterruptedException {
		// TODO Auto-generated method stub
		Context ctx=getInitialContext();
		JMSSubscriber subscriber=new JMSSubscriber();
		subscriber.init(ctx);
		System.out.println("Ready to receiver message");
		synchronized(subscriber){
			while(!quit){
				subscriber.wait();	
			}
		}	
		subscriber.close();
	}


}
