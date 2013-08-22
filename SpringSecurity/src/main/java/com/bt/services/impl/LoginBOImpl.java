package com.bt.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bt.dao.IBTUserDAO;
import com.bt.services.ILoginBO;
import com.bt.vo.User;

@Service
public class LoginBOImpl implements ILoginBO {
	@Autowired(required = false)
	IBTUserDAO	userDAO;

	public String loginValidate(final String username, final String password) {
		return null;
	}

	public String getUserPassword(final String username) {
		return userDAO.getUserPassword(username);
	}

	public List<User> getUserInfo(final String username) {
		return userDAO.selectUserInfo(username);
	}

	public Boolean login(final String username, final String password) {
		return null;
	}
}
