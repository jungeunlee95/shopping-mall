package com.cafe24.shoppingmall.config.test;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.cafe24.config.app.test.DBConfig;
import com.cafe24.config.app.test.MyBatisConfig;

@Configurable
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.shoppingmall.service.impl",
				"com.cafe24.shoppingmall.repository.impl"})
@Import({DBConfig.class, MyBatisConfig.class})
public class AppConfig {

}
