package com.cafe24.shoppingmall.config.test;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.cafe24.config.web.test.MVCConfig;
import com.cafe24.config.web.SwaggerConfig;

@Configurable
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.shoppingmall.controller", 
				"com.cafe24.shoppingmall.exception"})
@Import({MVCConfig.class, SwaggerConfig.class})
public class WebConfig {
 
}
