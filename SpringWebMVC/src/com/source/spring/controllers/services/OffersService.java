package com.source.spring.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.source.spring.controllers.dao.Offer;
import com.source.spring.controllers.dao.OffersDao;

@Service
public class OffersService {

	private OffersDao offersDao;
	
	@Autowired
	public void setOffersDao(OffersDao offersDao) {
		this.offersDao = offersDao;
	}

	public List<Offer> getCurrent(){
		return offersDao.getOffers();
	}
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})//this is to ensure if some hacker has bypassed url but he should still no be able 
	//to execute this method without admin privilages. This is method level security
	public void createOffer(Offer offer){
		offersDao.create(offer);
	}

/*	public void throwTestException() {
		
		offersDao.getOffer(9999);
	}*/
		
}
