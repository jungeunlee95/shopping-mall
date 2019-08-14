package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.shoppingmall.dto.OrderDto;
import com.cafe24.shoppingmall.dto.OrderProductDto;
import com.cafe24.shoppingmall.dto.RequestDeleteCartDto;
import com.cafe24.shoppingmall.dto.RequestNonUserOrderDto;
import com.cafe24.shoppingmall.dto.RequestNonUserOrderListDto;
import com.cafe24.shoppingmall.repository.CartDao;
import com.cafe24.shoppingmall.repository.OrderDao;
import com.cafe24.shoppingmall.vo.OptionNameVo;
import com.cafe24.shoppingmall.vo.OrderDetailVo;
import com.cafe24.shoppingmall.vo.OrderVo;
import com.cafe24.shoppingmall.vo.UserVo;

@Transactional(rollbackFor = Exception.class)
@Service 
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private CartDao cartDao;

	// =============================== 회원 ======================================= 
	public Boolean addOrder(OrderDto orderDto) {
		orderDto.setUserAddress(orderDto.getPostcode() + " " + orderDto.getRoadAddress() + " " + orderDto.getJibunAddress() + " " + orderDto.getExtraAddress() + " " +  orderDto.getDetailAddress());
		orderDto.setUserPhoneNumber(orderDto.getTxtMobile1() + "-" + orderDto.getTxtMobile2() + "-" + orderDto.getTxtMobile3());
		
		for(OrderProductDto vo : orderDto.getOrderProductDto()) {
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
		int order = orderDao.addOrder(orderDto);
		
		// 주문 상세정보 입력
		int orderDetail = orderDao.addOrderDetail(orderDto.getNo(), orderDto.getOrderProductDto());
		
		// 재고가 모두 있는 경우, 주문 후 재고 감소
		int reduceStock = orderDao.reduceStock(orderDto.getOrderProductDto());
		
		// 주문 완료 후 장바구니 비우기
		int deleteCart = cartDao.deleteProduct(orderDto.getUserNo(), orderDto.getOrderProductDto());		

		return order==1 && orderDetail == orderDto.getOrderProductDto().size();
	}

	public List<OrderDto> getOrderListByNo(Long userNo) {
		List<OrderDto> list = orderDao.getOrderList(userNo);
		return list;			
	}

	public List<OrderDetailVo> getOrderDetailList(Long no) {
		return orderDao.getOrderDetailList(no);
	}

	// ==========================================================================
	
	// =============================== 비회원 =======================================
//	public Boolean addOrder(RequestNonUserOrderDto requestNonUserOrderDto) {
//
//		for (OrderDetailVo vo : requestNonUserOrderDto.getProductOptionList()) {
//			OptionNameVo stockCheck = orderDao.stockCheck(vo.getProductOptionNo());
//			// 재고 체크를 하는 경우
//			if (stockCheck.getUseStock()) {
//				// 재고가 부족한 경우
//				if (vo.getQuantity() > stockCheck.getStock()) {
//					return false;
//				}
//			}
//		}
//
//		// 주문정보 입력
//		int order = orderDao.addOrder(requestNonUserOrderDto);
//
//		// 주문 상세정보 입력
//		int orderDetail = orderDao.addOrderDetail(requestNonUserOrderDto.getNo(), requestNonUserOrderDto.getProductOptionList());
//
//		// 재고가 모두 있는 경우, 주문 후 재고 감소
//		int reduceStock = orderDao.reduceStock(requestNonUserOrderDto.getProductOptionList());
//		
//		// 주문 완료 후 장바구니 비우기
//		int deleteCart = cartDao.deleteProduct(requestNonUserOrderDto.getNonUserNo(), requestNonUserOrderDto.getProductOptionList());
//
//		return order == 1 && orderDetail == requestNonUserOrderDto.getProductOptionList().size();
//	}
	
	public List<OrderVo> getOrderListByNo(RequestNonUserOrderListDto requestNonUserOrderListDto) {
		List<OrderVo> list = orderDao.getOrderList(requestNonUserOrderListDto);
		return list;			
	}
	//==========================================================================

	public List<OrderDto> getOrderList() {
		List<OrderDto> list = orderDao.getOrderList();
		return list;	
	}
}
