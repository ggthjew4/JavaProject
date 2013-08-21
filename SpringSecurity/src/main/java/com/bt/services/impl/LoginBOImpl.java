package com.bt.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bt.services.ILoginBO;

@Service
public class LoginBOImpl implements ILoginBO {


	public String loginValidate(final String username, final String password) {
		String rtnCode = "success";
		if ("user2".equals(username)) {
			rtnCode = "changepassword";
		}
		else if ("user3".equals(username)) {
			rtnCode = "lock";
		}
		return rtnCode;
	}

	public String getUserPassword(final String username) {
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("user", "user");
		userMap.put("user2", "user2");
		userMap.put("user3", "user3");
		userMap.put("admin", "admin");
		return userMap.get(username);
	}

	public Boolean login(final String username, final String password) {
		return null;
	}
}
