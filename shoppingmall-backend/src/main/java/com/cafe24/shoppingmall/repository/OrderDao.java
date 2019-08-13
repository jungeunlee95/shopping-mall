package com.cafe24.shoppingmall.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.dto.OrderDto;
import com.cafe24.shoppingmall.dto.OrderProductDto;
import com.cafe24.shoppingmall.dto.RequestNonUserOrderDto;
import com.cafe24.shoppingmall.dto.RequestNonUserOrderListDto;
import com.cafe24.shoppingmall.vo.OptionNameVo;
import com.cafe24.shoppingmall.vo.OrderDetailVo;
import com.cafe24.shoppingmall.vo.OrderVo;

@Repository
public class OrderDao{
	
	private final static String KEY = "aaa";
	
	@Autowired 
	private SqlSession sqlSession;

	// =============================== 회원 =======================================
	public int addOrder(OrderDto orderDto) {
		orderDto.setKey(KEY);
		return sqlSession.insert("order.insertOrderUser", orderDto);
	}

	public int addOrderDetail(Long no, List<OrderProductDto> list) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("orderDetailList", list);
		return sqlSession.insert("order.insertOrderDetail", map);
	}

	public OptionNameVo stockCheck(Long productOptionNo) {
		return sqlSession.selectOne("order.stockCheck", productOptionNo);
	}

	public int reduceStock(List<OrderProductDto> list) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productOptionList", list);
		return sqlSession.update("order.reduceStock", map);
	}

	// 주문 리스트
	public List<OrderVo> getOrderList(OrderVo orderVo) {
		orderVo.setKey(KEY);
		return sqlSession.selectList("order.getOrderListUser", orderVo);
	}
	
	public List<OrderDetailVo> getOrderDetailList(Long no) {
		return sqlSession.selectList("order.getOrderDetailList", no);
	}

	
	// ==========================================================================
	
	// =============================== 비회원 =======================================
	
	public int addOrder(RequestNonUserOrderDto requestNonUserOrderDto) {
		requestNonUserOrderDto.setKey(KEY);
		return sqlSession.insert("order.insertOrderNonUser", requestNonUserOrderDto);
	}

	// 비회원 주문 리스트
	public List<OrderVo> getOrderList(RequestNonUserOrderListDto requestNonUserOrderListDto) {
		requestNonUserOrderListDto.setKey(KEY);
		return sqlSession.selectList("order.getOrderListNonUser", requestNonUserOrderListDto);
	}
	
	// ==========================================================================
	
	// =============================== 관리자 =======================================
	// 전체 주문 목록
	public List<OrderDto> getOrderList() {
		return sqlSession.selectList("order.getAllOrderList");
	}
	// ==========================================================================
}

