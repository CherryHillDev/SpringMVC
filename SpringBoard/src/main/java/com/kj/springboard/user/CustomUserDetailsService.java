package com.kj.springboard.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO vo = new UserVO();
		vo.setUsername(username);
		
		System.out.println("===> username : "+username);
		
		UserVO user = userService.getUser(vo);
		
		CustomUserDetails userDetails = new CustomUserDetails();
		if(user==null) {
			return null;
		}else {
			userDetails.setUsername(user.getUsername());
			userDetails.setPassword("{noop}"+user.getPassword());
			userDetails.setAuthorities(user.getAuthority());	//권한은 여러 개일 수 있어서 List..일단은 하나씩
			System.out.println("userAuthority : " + user.getAuthority());
		}
		
		return userDetails;
		
	}
	
}
