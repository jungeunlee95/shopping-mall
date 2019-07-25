package com.cafe24.shoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.OrderDao;
import com.cafe24.shoppingmall.vo.OrderVo;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	public Boolean addOrder(OrderVo orderVo) {
		int result = orderDao.addOrder(orderVo);
		int result2 = orderDao.addOrderDetail(orderVo.getNo(), orderVo.getProductOptionList());
		return result==1 && result2 == orderVo.getProductOptionList().size();
	}

}
