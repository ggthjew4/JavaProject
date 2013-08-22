package com.bt.dao;

import java.util.List;

import com.bt.vo.User;

public interface IBTUserDAO {
	
	public List<User> selectUserInfo(final String username);
	
	public String getUserPassword(final String username);
}
