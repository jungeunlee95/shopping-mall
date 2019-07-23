package com.cafe24.shoppingmall.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cafe24.shoppingmall.validator.constraints.ValidId;
import com.cafe24.shoppingmall.validator.constraints.ValidPassword;
import com.cafe24.shoppingmall.validator.constraints.ValidPhoneNumber;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
	
	private Pattern pattern = Pattern.compile("(^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)[a-zA-Z\\\\d]{8,16}$)");
			

	@Override 
	public void initialize(ValidPhoneNumber constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null || value.length()==0 || "".contentEquals(value)) {
			return false;
		} 
		
		return pattern.matcher( value ).matches();
		
	}

}
