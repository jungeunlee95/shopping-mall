package com.example.shoppingmall.frontend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.example.shoppingmall.frontend.config.web.MVCConfig;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.example.shoppingmall.frontend.controller"})
@Import({ MVCConfig.class })
public class WebConfig {
}
