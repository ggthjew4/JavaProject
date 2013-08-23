package com.bt.security;

import java.util.Collection;
import java.util.Collections;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class BTUserDetails implements UserDetails {
	private static final long				serialVersionUID	= 5229206868112838662L;
	private String							username;
	private String							password;
	private Collection<GrantedAuthority>	grantedAuthoritys;

	public BTUserDetails() {
		this.username = StringUtils.EMPTY;
		this.password = StringUtils.EMPTY;
		this.grantedAuthoritys = Collections.emptyList();
	}

	public BTUserDetails(final String username, final String password, final Collection<GrantedAuthority> grantedAuthoritys) {
		this.username = username;
		this.password = password;
		this.grantedAuthoritys = grantedAuthoritys;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		return grantedAuthoritys;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}
}
