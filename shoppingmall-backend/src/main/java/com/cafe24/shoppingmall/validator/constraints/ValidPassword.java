package com.cafe24.shoppingmall.validator.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.cafe24.shoppingmall.validator.IdValidator;
import com.cafe24.shoppingmall.validator.PasswordValidator;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy=PasswordValidator.class)
public @interface ValidPassword {
	
	String message() default "잘못된 비밀번호 형식입니다.";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
 