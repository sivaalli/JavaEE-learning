package com.source.spring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.source.spring.controllers.dao.User;
import com.source.spring.controllers.services.UsersService;

@Controller
public class LoginController {

	private UsersService usersService;

	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/loginform")
	public String showLogin() {
		return "loginform";
	}
	
	@RequestMapping("/adminpage")
	public String showAdmin(Model model) {
		
		List<User> users = usersService.getAllUsers();
		model.addAttribute("users", users);
		return "adminpage";
	}
	
	@RequestMapping("/denied")
	public String showDenyed() {
		return "denied";
	}

	
	@RequestMapping("/loggedout")
	public String showLogout() {
		return "loggedout";
	}

	@RequestMapping("/newaccount")
	public String showCreateAccount(Model model) {
		model.addAttribute("user", new User());
		return "newaccount";
	}

	@RequestMapping(value = "/createaccount", method = RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "newaccount";
		}
		user.setAuthority("ROLE_USER");
		user.setEnabled(true);
		
		if(usersService.exists(user.getUsername())){
			result.rejectValue("username", "DuplicateKey.user.username"); 
			return "newaccount";
		}
		usersService.createUser(user);
		
		//This approach still works great. But its not encouraged to catch exceptions here and do this kind of stuff here
		/*try {
			usersService.createUser(user);
		} catch (DuplicateKeyException e) {
			result.rejectValue("username", "DuplicateKey.user.username", "This user already exists!");
			return "newaccount";
		}*/

		return "accountcreated";
	}
}
