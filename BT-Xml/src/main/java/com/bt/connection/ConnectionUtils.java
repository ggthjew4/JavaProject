package com.bt.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtils {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/practice";
			conn = DriverManager.getConnection(url, "rock", "rock");
		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection(final Connection conn) {
		if (null == conn) {
			throw new NullPointerException("Connection must be require.");
		}
		try {
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeStatement(final Statement st) {
		if (null == st) {
			throw new NullPointerException("Statement must be require.");
		}
		try {
			st.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
