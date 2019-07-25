package com.cafe24.shoppingmall.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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


}
