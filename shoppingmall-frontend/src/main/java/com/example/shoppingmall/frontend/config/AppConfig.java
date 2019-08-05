package com.example.shoppingmall.frontend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.example.shoppingmall.frontend.config.app.AppSecurityConfig;
import com.example.shoppingmall.frontend.config.app.OAuth2ClientConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.example.shoppingmall.frontend.security", "com.example.shoppingmall.frontend.service",  "com.example.shoppingmall.frontend.repository", "com.example.shoppingmall.frontend.aspect"})
@Import({ AppSecurityConfig.class, OAuth2ClientConfig.class })
public class AppConfig {
}