package com.cafe24.shoppingmall.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.cafe24.shoppingmall.dto.JSONResult;


//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    public void configure(WebSecurity web) throws Exception {
        //super.configure(web); // 아무런 작업을 하지 않음

        // 스프링 시큐리티의 필터 연결을 설정하기 위한 오버라이딩이다.
        // 예외가 웹접근 URL를 설정한다.
        // ACL(Access Control List - 접근 제어 목록)의 예외 URL을 설정
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 인터셉터로 요청을 안전하게 보호하는 방법을 설정하기 위한 오버라이딩이다. ( ACL )
        http.authorizeRequests()
        	.antMatchers("/oauth/token").permitAll()
//        	.anyRequest().permitAll()
        // 예외처리
        
    	.and()
       	.exceptionHandling()
    	.accessDeniedHandler(new AccessDeniedHandler() {
			@Override
			public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
		    	JSONResult jsonResult = JSONResult.fail( "Access Denied" );
		    	
		    	MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		    	if( jsonConverter.canWrite( jsonResult.getClass(), MediaType.APPLICATION_JSON ) ) {
		        	jsonConverter.write( jsonResult, MediaType.APPLICATION_JSON, new ServletServerHttpResponse( response ) );
		    	}
			}
    	});
        
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 사용자 세부 서비스를 설정하기 위한 오버라이딩이다.
        super.configure(auth);
    }
}