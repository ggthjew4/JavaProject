package com.bt.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bt.services.ILoginBO;
import com.bt.vo.User;

public class BTUserDetailService implements UserDetailsService {
	@Autowired(required = false)
	ILoginBO	loginBO;

	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException, DataAccessException {
		final List<User> users = loginBO.getUserInfo(username);
		return new BTUserDetails(users.get(0).getUsername(), users.get(0).getPassword(),this.obtainGrantedAuthorityList(users));
	}

	private List<GrantedAuthority> obtainGrantedAuthorityList(final List<User> users) {
		List<GrantedAuthority> returnList = new ArrayList<GrantedAuthority>();
		for (User user : users) {
			returnList.add(new GrantedAuthorityImpl(user.getGrantedAuthority()));
		}
		return returnList;
	}
}
