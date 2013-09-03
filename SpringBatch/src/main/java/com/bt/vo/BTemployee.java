package com.bt.vo;

import java.io.Serializable;

public class BTemployee implements Serializable {
	private static final long	serialVersionUID	= -5230955159347244080L;
	private String				depId;
	private String				memId;
	private String				engName;
	private String				chiName;
	private String				emailAddr;
	private String				msnAddr;

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getChiName() {
		return chiName;
	}

	public void setChiName(String chiName) {
		this.chiName = chiName;
	}

	public String getEmailAddr() {
		return emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	public String getMsnAddr() {
		return msnAddr;
	}

	public void setMsnAddr(String msnAddr) {
		this.msnAddr = msnAddr;
	}
}
