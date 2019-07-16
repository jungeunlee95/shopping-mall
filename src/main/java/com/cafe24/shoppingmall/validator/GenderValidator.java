package com.cafe24.shoppingmall.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cafe24.shoppingmall.validator.constraints.ValidGender;

public class GenderValidator implements ConstraintValidator<ValidGender, String> {
	
	private Pattern pattern = Pattern.compile("M|F");
			

	@Override
	public void initialize(ValidGender constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null || value.length()==0 || "".contentEquals(value)) {
			return false;
		} 
		
		return pattern.matcher( value ).matches();
		
	}

}
