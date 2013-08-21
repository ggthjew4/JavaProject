package com.bt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bt.services.ILoginBO;

public class BTUserDetailService implements UserDetailsService {
	
	@Autowired(required = false)
	ILoginBO loginBO;
	
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException, DataAccessException {
		final String pw = loginBO.getUserPassword(username);
		return new BTUserDetails(username, pw);
	}
}
