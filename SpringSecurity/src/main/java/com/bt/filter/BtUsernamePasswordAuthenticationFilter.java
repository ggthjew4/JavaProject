package com.bt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bt.services.ILoginBO;

public class BtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	@Autowired
	ILoginBO		loginBO;
	private String	principalRequestHeader	= "SM_USER";

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) req;
		String sUserId = request.getHeader(principalRequestHeader);
		if (StringUtils.isBlank(sUserId)) {
			sUserId = request.getParameter("j_username");
			if (StringUtils.isNotBlank(sUserId)) {
				request.getSession().setAttribute(principalRequestHeader, sUserId);
			}
			super.doFilter(req, res, chain);
		}
		else {
			final String iv_user = (String) request.getSession().getAttribute(principalRequestHeader);
			if (StringUtils.isBlank(iv_user)) {
				request.getSession().setAttribute("iv-user", sUserId);
			}
			chain.doFilter(req, res);
		}
	}
}
