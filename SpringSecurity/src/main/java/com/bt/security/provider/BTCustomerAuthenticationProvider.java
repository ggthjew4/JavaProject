package com.bt.security.provider;

import java.util.Collection;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class BTCustomerAuthenticationProvider extends DaoAuthenticationProvider {
	
	private String roleAdminAuthority = "ROLE_ADMIN";
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		super.additionalAuthenticationChecks(userDetails, authentication);
		Collection<GrantedAuthority> list = userDetails.getAuthorities();
		for (GrantedAuthority authority : list) {
			if (roleAdminAuthority.equals(authority.getAuthority())) {
				throw new BadCredentialsException(messages.getMessage("bt.badCredentials.admin.login.error", "BT Admin credentials"), super.isIncludeDetailsObject() ? userDetails : null);
			}
		}
	}
}
