package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.shoppingmall.repository.OrderDao;
import com.cafe24.shoppingmall.vo.OptionNameVo;
import com.cafe24.shoppingmall.vo.OrderDetailVo;
import com.cafe24.shoppingmall.vo.OrderVo;

@Service 
@Transactional
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	public Boolean addOrder(OrderVo orderVo) {
		
		for(OrderDetailVo vo : orderVo.getProductOptionList()) {
			OptionNameVo stockCheck = orderDao.stockCheck(vo.getProductOptionNo());
			// 재고 체크를 하는 경우
			if(stockCheck.getUseStock()) {
				// 재고가 부족한 경우
				if(vo.getQuantity() > stockCheck.getStock()) {
					return false;
				}
			}
		} 

		// 주문정보 입력
		int order = orderDao.addOrder(orderVo);
		
		// 주문 상세정보 입력
		int orderDetail = orderDao.addOrderDetail(orderVo.getNo(), orderVo.getProductOptionList());
		
		// 재고가 모두 있는 경우, 주문 후 재고 감소
		int reduceStock = orderDao.reduceStock(orderVo.getProductOptionList());
		
		return order==1 && orderDetail == orderVo.getProductOptionList().size();
	}

	public List<OrderVo> getOrderListByNo(Long no) {
		return orderDao.getOrderListByNo(no);
	}

	public List<OrderDetailVo> getOrderDetailList(Long no) {
		return orderDao.getOrderDetailList(no);
	}

}
