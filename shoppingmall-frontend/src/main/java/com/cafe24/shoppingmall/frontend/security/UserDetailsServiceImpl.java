package com.cafe24.shoppingmall.frontend.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cafe24.shoppingmall.frontend.repository.UserDao;
import com.cafe24.shoppingmall.frontend.vo.UserVo;




@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserVo userVo = userDao.get(email);
		
		SecurityUser securityUser = new SecurityUser();
		
		if(userVo != null) {
			securityUser.setNo(userVo.getNo());
			securityUser.setName(userVo.getName());
			securityUser.setUsername(userVo.getEmail());
			securityUser.setPassword(userVo.getPassword());
			securityUser.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(userVo.getRole())));
		}
		
		return securityUser;
	}	
}
