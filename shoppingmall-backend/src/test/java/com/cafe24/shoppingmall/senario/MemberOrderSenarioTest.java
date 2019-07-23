package com.cafe24.shoppingmall.senario;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cafe24.shoppingmall.controller.CartControllerTest;
import com.cafe24.shoppingmall.controller.MainControllerTest;
import com.cafe24.shoppingmall.controller.ProductControllerTest;
import com.cafe24.shoppingmall.controller.UserControllerTest;

import junit.framework.Test;
import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	UserControllerTest.class,
	MainControllerTest.class,
	ProductControllerTest.class,
	CartControllerTest.class
})
public class MemberOrderSenarioTest {

	public static Test suite() {
		return new TestSuite("회원 주문 시나리오 테스트");
	}
}













