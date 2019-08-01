package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.shoppingmall.dto.RequestDeleteCartDto;
import com.cafe24.shoppingmall.dto.RequestNonUserOrderDto;
import com.cafe24.shoppingmall.dto.RequestNonUserOrderListDto;
import com.cafe24.shoppingmall.repository.CartDao;
import com.cafe24.shoppingmall.repository.OrderDao;
import com.cafe24.shoppingmall.vo.OptionNameVo;
import com.cafe24.shoppingmall.vo.OrderDetailVo;
import com.cafe24.shoppingmall.vo.OrderVo;

@Transactional(rollbackFor = Exception.class)
@Service 
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private CartDao cartDao;

	// =============================== 회원 ======================================= 
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
		
		// 주문 완료 후 장바구니 비우기
		int deleteCart = cartDao.deleteProduct(orderVo.getUserNo(), orderVo.getProductOptionList());		

		return order==1 && orderDetail == orderVo.getProductOptionList().size();
	}

	public List<OrderVo> getOrderListByNo(OrderVo orderVo) {
		List<OrderVo> list = orderDao.getOrderList(orderVo);
		return list;			
	}

	public List<OrderDetailVo> getOrderDetailList(Long no) {
		return orderDao.getOrderDetailList(no);
	}

	// ==========================================================================
	
	// =============================== 비회원 =======================================
	public Boolean addOrder(RequestNonUserOrderDto requestNonUserOrderDto) {

		for (OrderDetailVo vo : requestNonUserOrderDto.getProductOptionList()) {
			OptionNameVo stockCheck = orderDao.stockCheck(vo.getProductOptionNo());
			// 재고 체크를 하는 경우
			if (stockCheck.getUseStock()) {
				// 재고가 부족한 경우
				if (vo.getQuantity() > stockCheck.getStock()) {
					return false;
				}
			}
		}

		// 주문정보 입력
		int order = orderDao.addOrder(requestNonUserOrderDto);

		// 주문 상세정보 입력
		int orderDetail = orderDao.addOrderDetail(requestNonUserOrderDto.getNo(), requestNonUserOrderDto.getProductOptionList());

		// 재고가 모두 있는 경우, 주문 후 재고 감소
		int reduceStock = orderDao.reduceStock(requestNonUserOrderDto.getProductOptionList());
		
		// 주문 완료 후 장바구니 비우기
		int deleteCart = cartDao.deleteProduct(requestNonUserOrderDto.getNonUserNo(), requestNonUserOrderDto.getProductOptionList());

		return order == 1 && orderDetail == requestNonUserOrderDto.getProductOptionList().size();
	}
	
	public List<OrderVo> getOrderListByNo(RequestNonUserOrderListDto requestNonUserOrderListDto) {
		List<OrderVo> list = orderDao.getOrderList(requestNonUserOrderListDto);
		return list;			
	}
	//==========================================================================
}
