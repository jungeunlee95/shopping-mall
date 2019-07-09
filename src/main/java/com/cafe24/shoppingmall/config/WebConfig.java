package com.cafe24.shoppingmall.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configurable
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.shoppingmall.hello.controller"})
public class WebConfig {

}
