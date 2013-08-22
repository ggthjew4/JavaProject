package com.bt.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.TextEscapeUtils;

import com.bt.services.ILoginBO;

public class BtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	@Autowired
	ILoginBO loginBO;
	
	private String	principalRequestHeader	= "SM_USER";
	private boolean	postOnly				= true;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		
		
		if (postOnly && !request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}
		String username = obtainUsername(request);
		String password = obtainPassword(request);
		if (username == null) {
			username = "";
		}
		if (password == null) {
			password = "";
		}
		username = username.trim();
		
		if(this.isSSOChannel(request)){
			username = request.getHeader(principalRequestHeader).trim();
			password = loginBO.getUserPassword(username);
		}
		
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
		// Place the last username attempted into HttpSession for views
		HttpSession session = request.getSession(false);
		if (session != null || getAllowSessionCreation()) {
			request.getSession().setAttribute(SPRING_SECURITY_LAST_USERNAME_KEY, TextEscapeUtils.escapeEntities(username));
		}
		// Allow subclasses to set the "details" property
		setDetails(request, authRequest);
		return this.getAuthenticationManager().authenticate(authRequest);
	}

	/**
	 * Defines whether only HTTP POST requests will be allowed by this filter. If set to true, and an authentication request is received which is not a POST request, an exception will be raised
	 * immediately and authentication will not be attempted. The <tt>unsuccessfulAuthentication()</tt> method will be called as if handling a failed authentication.
	 * <p>
	 * Defaults to <tt>true</tt> but may be overridden by subclasses.
	 */
	public void setPostOnly(boolean postOnly) {
		this.postOnly = postOnly;
	}

	private boolean isSSOChannel(final HttpServletRequest request) {
		final String principal = request.getHeader(principalRequestHeader);
		if (StringUtils.isNotBlank(principal)) {
			return true;
		}
		else {
			return false;
		}
	}
}
