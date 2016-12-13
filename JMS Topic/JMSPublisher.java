package com.source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicPublisher;
import javax.jms.*;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSPublisher {

	public final static String JMS_FACTORY="MyTopicConnectionFactory";
	public final static String TOPIC="MyTopic";
	
	private TopicConnectionFactory tconFactory;
	private TopicConnection tcon;
	private TopicSession tSession;
	private TopicPublisher tPublisher;
	private Topic topic;
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
		tconFactory=(TopicConnectionFactory)ctx.lookup(JMS_FACTORY);
		tcon=(TopicConnection) tconFactory.createConnection();
		tSession=tcon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic=(Topic)ctx.lookup(TOPIC);
		tPublisher=tSession.createPublisher(topic);
		textMessage=tSession.createTextMessage();
		tcon.start();
	}
	
	public void sendMessage(String msg) throws JMSException{
		textMessage.setText(msg);
		tPublisher.send(textMessage);
	}
	
	public void close() throws JMSException{
		tPublisher.close();
		tSession.close();
		tcon.close();
	}
	
	public void readAndSend(JMSPublisher publisher) throws IOException, JMSException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String msg = null;
		System.out.println("Please type any message");
		msg=br.readLine();
		while(msg!=null){	
			publisher.sendMessage(msg);
			System.out.println("Message sent");
			if(msg.equalsIgnoreCase("quit")) break;
			msg=br.readLine();	
			
		}
	}
	public static void main(String[] args) throws NamingException, JMSException, IOException {
		// TODO Auto-generated method stub
		Context ctx=getInitialContext();
		JMSPublisher publisher=new JMSPublisher();
		publisher.init(ctx);
		publisher.readAndSend(publisher);
		publisher.close();
	}

}
