package com.cafe24.shoppingmall.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.OptionNameVo;
import com.cafe24.shoppingmall.vo.OrderDetailVo;
import com.cafe24.shoppingmall.vo.OrderVo;

@Repository
public class OrderDao{
	
	private final static String KEY = "aaa";
	
	@Autowired 
	private SqlSession sqlSession;

	public int addOrder(OrderVo orderVo) {
		orderVo.setKey(KEY);
		return sqlSession.insert("order.insertOrder", orderVo);
	}

	public int addOrderDetail(Long no, List<OrderDetailVo> orderDetailList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("orderDetailList", orderDetailList);
		return sqlSession.insert("order.insertOrderDetail", map);
	}

	public OptionNameVo stockCheck(Long productOptionNo) {
		return sqlSession.selectOne("order.stockCheck", productOptionNo);
	}

	public int reduceStock(List<OrderDetailVo> productOptionList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productOptionList", productOptionList);
		return sqlSession.update("order.reduceStock", map);
	}

	public List<OrderVo> getOrderListByNo(Long no) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("key", KEY);
		return sqlSession.selectList("order.getOrderListByNo", map);
	}

	public List<OrderDetailVo> getOrderDetailList(Long no) {
		return sqlSession.selectList("order.getOrderDetailList", no);
	}


}
