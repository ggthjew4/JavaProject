package com.bt.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class BTUserDetails implements UserDetails {
	private static final long	serialVersionUID	= 5229206868112838662L;
	private String				username;
	private String				password;
	private Collection<GrantedAuthority> grantedAuthoritys;

	public BTUserDetails(final String username, final String password,final Collection<GrantedAuthority> grantedAuthoritys) {
		this.username = username;
		this.password = password;
		this.grantedAuthoritys = grantedAuthoritys;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		return grantedAuthoritys;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
