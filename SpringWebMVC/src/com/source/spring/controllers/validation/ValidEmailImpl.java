package com.source.spring.controllers.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.EmailValidator;

public class ValidEmailImpl implements ConstraintValidator<ValidEmail, String>{

	private int min;
	@Override
	public void initialize(ValidEmail constraintAnnotation) {
		min = constraintAnnotation.min();
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		
		if(email.length() >=min && EmailValidator.getInstance(false).isValid(email)){
			return true;
		}	
		return false;
	}

}
