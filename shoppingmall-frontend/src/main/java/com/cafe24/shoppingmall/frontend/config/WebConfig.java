package com.cafe24.shoppingmall.frontend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.cafe24.shoppingmall.frontend.config.web.MVCConfig;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.shoppingmall.frontend.controller"})
@Import({ MVCConfig.class })
public class WebConfig {
}
