package com.bt.services;

public interface ILoginBO {
	
	public Boolean login(final String username, final String password); 
	public String loginValidate(final String username, final String password);
	public String getUserPassword(final String username);

}
