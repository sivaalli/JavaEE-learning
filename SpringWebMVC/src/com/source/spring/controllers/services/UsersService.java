package com.source.spring.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.source.spring.controllers.dao.User;
import com.source.spring.controllers.dao.UsersDao;

@Service
public class UsersService {

	private UsersDao usersDao;
	
	@Autowired
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public void createUser(User user){
		usersDao.create(user);
	}

	public boolean exists(String username) {
		return usersDao.exists(username);
		
	}
	
	@Secured("ROLE_ADMIN")//this is to ensure if some hacker has bypassed url but he should still no be able 
	//to execute this method without admin privilages. This is method level security
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return usersDao.getAllUsers();
	}
	
}
