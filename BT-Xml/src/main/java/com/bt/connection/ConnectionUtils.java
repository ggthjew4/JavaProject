package com.bt.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;

public class ConnectionUtils {
	private final static Logger	logger	= Logger.getLogger(ConnectionUtils.class);

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/practice";
			conn = DriverManager.getConnection(url, "rock", "rock");
		}
		catch (InstantiationException e) {
			logger.trace("getConnection Occurs InstantiationException", e);
		}
		catch (IllegalAccessException e) {
			logger.trace("getConnection IllegalAccessException", e);
		}
		catch (ClassNotFoundException e) {
			logger.trace("getConnection ClassNotFoundException", e);
		}
		catch (SQLException e) {
			logger.trace("getConnection SQLException", e);
		}
		return conn;
	}

	public static void closeConnection(final Connection conn) {
		Assert.notNull(conn, "Connection must be require.");
		try {
			conn.close();
		}
		catch (SQLException e) {
			logger.trace("closeConnection SQLException", e);
		}
	}

	public static Statement createStatement(final Connection conn) {
		Assert.notNull(conn, "Connection must be require");
		Statement st = null;
		try {
			st = conn.createStatement();
		}
		catch (SQLException e) {
			logger.error("createStatement SQLException", e);
		}
		return st;
	}

	public static PreparedStatement createPrepareStatement(final Connection conn, final String sql) {
		Assert.notNull(conn, "Connection must be require");
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
		}
		catch (SQLException e) {
			logger.error("createPrepareStatement SQLException", e);
		}
		return st;
	}

	public static void closeStatement(final Statement st) {
		Assert.notNull(st, "Statement must be require.");
		try {
			st.close();
		}
		catch (SQLException e) {
			logger.trace("closeStatement SQLException", e);
		}
	}
}
