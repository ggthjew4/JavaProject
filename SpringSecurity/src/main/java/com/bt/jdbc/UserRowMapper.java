package com.bt.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bt.vo.User;

public class UserRowMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = this.getNewUserInstance();
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setEnable(rs.getBoolean("enable"));
		user.setGrantedAuthority(rs.getString("authority"));
		return user;
	}

	private User getNewUserInstance() {
		return new User();
	}
}
