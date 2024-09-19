package com.example.kartiksapra.watchlist.entity.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriorityAnnotationLogic implements ConstraintValidator<Priority, String>{
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return value.trim().length() == 1 && "LHM".contains(value.trim());     //After triming the String it Check the Length of the string if it's equal to 1 then it's true anotherwise it return false.
		
	}
}
