package com.bt.services;

import java.util.List;

import com.bt.vo.User;

public interface ILoginBO {
	
	public Boolean login(final String username, final String password); 
	public String loginValidate(final String username, final String password);
	public String getUserPassword(final String username);
	public List<User> getUserInfo(final String username);

}
