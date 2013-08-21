package com.bt.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.preauth.PreAuthenticatedCredentialsNotFoundException;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

public class BtRequestHeaderAuthenticationFilter extends RequestHeaderAuthenticationFilter {
	private String principalRequestHeader = "SM_USER";
	@Override
	protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
		
		String principal = request.getHeader(principalRequestHeader);
		if(principal == null){
			super.setExceptionIfHeaderMissing(false);
		}
		if (principal == null ) {
			throw new PreAuthenticatedCredentialsNotFoundException(principalRequestHeader + " header not found in request.");
		}
		return principal;
	}
}
