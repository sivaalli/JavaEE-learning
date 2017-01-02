package com.source.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/source/spring/beans/beans.xml");
		
		OffersDAO offersDAO = (OffersDAO)context.getBean("offersDAO");
	/*	try {
			List<Offer> offers =  offersDAO.getOffers();
			for(Offer offer:offers){
				System.out.println(offer);
			}
		} catch (BadSqlGrammarException e) {
			e.getMessage();
			e.getClass();
		}*/
		
		//To get all rows
		boolean deleted = offersDAO.delete(2);
		if(deleted){
			System.out.println("Deleted one row");
		}
		
		boolean inserted = offersDAO.create(new Offer("shiva", "siva_alli@hotmail.com", "I'm shiva praneeth"));
		if(inserted){
			System.out.println("Inserted row");
		}
		
		System.out.println(deleted);
		List<Offer> offers =  offersDAO.getOffers();
		for(Offer offer:offers){
			System.out.println(offer);
		}
		
		Offer offer = offersDAO.getOffer(1);
		System.out.println("Must be Bob: "+offer);
		
		((ClassPathXmlApplicationContext)context).close();
	
	}

}
