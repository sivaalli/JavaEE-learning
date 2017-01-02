package com.source.spring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.source.spring.controllers.dao.Offer;
import com.source.spring.controllers.services.OffersService;

@Controller
public class OffersController {
	
	private OffersService offersService;
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}
	
	@RequestMapping(value="/test" ,method=RequestMethod.GET )
	public String showTest(Model model, @RequestParam("id") String id){
		System.out.println("The id is : "+id);
		return "home";
	}
	
	
	//we can use ModelAndView, HttpContext, HttpRequest to pass to this method as arguments
	@RequestMapping("/offers")
	public String showOffers(Model model){
		//offersService.throwTestException();                  //Testing exceptions ---do not uncomment this-----  
		List<Offer> offers = offersService.getCurrent();
		model.addAttribute("offers", offers);
		return "offers";
	}
	
	/*@ExceptionHandler(DataAccessException.class)
	public String handleDataAccessException(DataAccessException e){
		return "error";
	}*/
	
	
	@RequestMapping(value="/createoffer")
	public String createOffer(Model model){
		Offer offer = new Offer();
		model.addAttribute("offer", offer);
		return "createoffer";
	}
	
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(Model model,@Valid Offer offer, BindingResult result){
		if(result.hasErrors()){
			/*System.out.println("Form has error");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error:errors){
				System.out.println(error.getDefaultMessage());
			}*/
			return "createoffer"; 
		}
		offersService.createOffer(offer);
		//System.out.println(offer);
		return "offercreated";
	}
	

	
	
	

	
	
}
