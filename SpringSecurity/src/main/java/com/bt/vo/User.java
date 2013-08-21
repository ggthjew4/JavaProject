package com.bt.vo;

import java.io.Serializable;

public class User implements Serializable {
	private static final long	serialVersionUID	= -2379411597908435042L;
	private String				username;
	private String				password;
	private boolean				isEnable;
	private String				grantedAuthority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}

	public String getGrantedAuthority() {
		return grantedAuthority;
	}

	public void setGrantedAuthority(String grantedAuthority) {
		this.grantedAuthority = grantedAuthority;
	}
}
