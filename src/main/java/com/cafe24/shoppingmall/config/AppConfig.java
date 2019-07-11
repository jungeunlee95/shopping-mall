package com.cafe24.shoppingmall.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.cafe24.config.app.DBConfig;
import com.cafe24.config.app.MyBatisConfig;

@Configurable
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.shoppingmall.user.service",
				"com.cafe24.shoppingmall.user.repository",
				"com.cafe24.shoppingmall.product.service",
				"com.cafe24.shoppingmall.product.repository"})
@Import({DBConfig.class, MyBatisConfig.class})
public class AppConfig {

}
