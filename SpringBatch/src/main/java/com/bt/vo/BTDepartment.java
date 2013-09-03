package com.bt.vo;

import java.io.Serializable;

public class BTDepartment implements Serializable {
	private static final long	serialVersionUID	= -2848838425955476855L;
	private String				depId;
	private String				depName;

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}
}
