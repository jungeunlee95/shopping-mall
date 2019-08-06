package com.cafe24.shoppingmall.frontend.security;

import org.springframework.core.MethodParameter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class AuthUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public Object resolveArgument(
		MethodParameter parameter,
		ModelAndViewContainer mavContainer,
		NativeWebRequest webRequest,
		WebDataBinderFactory binderFactory) throws Exception {
		
		Object principal = null;
		if(SecurityContextHolder.getContext().getAuthentication() != null){
			principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		
		if(principal == null || principal.getClass() == String.class) {
			return null;
		} 
		
		return principal;
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		AuthUser authUser = parameter.getParameterAnnotation(AuthUser.class);
		
		// @AuthUser가 안붙어 있음
		if( authUser == null ) {
			return false;
		}
		
		// 파라미터 타입이 UserVo가 아님
		if(parameter.getParameterType().equals( SecurityUser.class ) == false) {
			return false;
		}
		
		return true;
	}
}