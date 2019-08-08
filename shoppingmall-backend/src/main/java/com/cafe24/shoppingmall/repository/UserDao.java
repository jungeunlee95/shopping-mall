package com.cafe24.shoppingmall.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.UserAddressVo;
import com.cafe24.shoppingmall.vo.UserVo;

@Repository
public class UserDao{
	
	private final static String KEY = "aaa";
	
	@Autowired 
	private SqlSession sqlSession;

	public int insert(UserVo vo) { 
		vo.setKey(KEY);
		return sqlSession.insert("user.insert", vo);
	}

	public UserVo getId(String id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", KEY);
		map.put("id", id);
		return sqlSession.selectOne("user.selectId", map);
	}
	
	public List<UserVo> getUserList() {
		return sqlSession.selectList("user.getUserList", KEY);
	}

	public UserVo get(String id, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", KEY);
		map.put("id", id);
		map.put("password", password);
		UserVo vo = sqlSession.selectOne("user.getUser", map);
		return vo;
	}

	public UserVo get(String email) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", KEY);
		map.put("email", email);
		UserVo vo = sqlSession.selectOne("user.findId", map);
		return vo;
	}
	
	public UserVo getLogin(String id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", KEY);
		map.put("id", id);
		UserVo vo = sqlSession.selectOne("user.loginS", map);
		return vo;
	}

	public UserVo update(UserVo userVo) {
		userVo.setKey(KEY);
		sqlSession.update("user.modify", userVo); 
		return userVo;
	}

	public Boolean deleteUser(Long no) {
		return 1==sqlSession.delete("user.delete", no); 
	}

	public int insertUserAddress(UserAddressVo userAddressVo) {
		userAddressVo.setKey(KEY);
		return sqlSession.insert("user.insertAddress", userAddressVo);
	}

	public List<UserAddressVo> getUserAddressList(Long userNo) {
		return sqlSession.selectList("user.getAddressList", userNo);
	}
	
	public UserAddressVo getUserAddress(Long addressNo) {
		return sqlSession.selectOne("user.getAddress", addressNo);
	}

	public int deleteAddress(Long addressNo) {
		return sqlSession.delete("user.deleteAddress", addressNo);
	}

	public UserVo getUserDetail(Long userNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", KEY);
		map.put("userNo", userNo); 
		return sqlSession.selectOne("user.getUserDetail", map);
	} 


}
