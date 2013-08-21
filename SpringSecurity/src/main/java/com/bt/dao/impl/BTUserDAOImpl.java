package com.bt.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bt.dao.IBTUserDAO;
import com.bt.jdbc.UserRowMapper;
import com.bt.vo.User;

@Repository
public class BTUserDAOImpl implements IBTUserDAO {
	@Autowired
	JdbcTemplate	jdbcTemplate;

	public List<User> selectUserInfo(final String username) {
		final String sql = "select users.username,users.password,users.enable,user_roles.authority from users INNER JOIN user_roles on users.id = user_roles.user_id where users.username=? ";
		return jdbcTemplate.query(sql, new String[] { username }, new UserRowMapper());
	}
}
