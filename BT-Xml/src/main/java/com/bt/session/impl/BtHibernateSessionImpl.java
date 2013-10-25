package com.bt.session.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bt.connection.ConnectionUtils;
import com.bt.session.BtHibernateSession;
import com.bt.xml.BtXmlParsingHelp;
import com.bt.xml.jaxb.BluetechnologyMapping;
import com.bt.xml.sql.impl.BtSqlPlain;

public class BtHibernateSessionImpl implements BtHibernateSession {
	Connection								conn;
	BluetechnologyMapping					mapping;
	private final static ApplicationContext	SPRING_CONTEXT	= new ClassPathXmlApplicationContext("Spring-Configuration.xml");

	public BtHibernateSessionImpl(Connection conn) {
		this.conn = conn;
		this.mapping = ((BtXmlParsingHelp) SPRING_CONTEXT.getBean("XMLConverter")).loadXMLFile("bt_hibernate.xml");
	}

	public <T> List<T> list(final Class<T> clazz) {
		final List<T> resultList = new ArrayList<T>();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(getBtSqlPlain(clazz.getName()).getQuerySql());
			while (rs.next()) {
				Map<String, Object> resultMap = new HashMap<String, Object>();
				for (BluetechnologyMapping.Class.Property property : getBtSqlPlain(clazz.getName()).getMappingProperty()) {
					resultMap.put(property.getName(), rs.getObject(property.getColumn()));
				}
				T resultObject = (T) (Class.forName(clazz.getName()).newInstance());
				BeanUtils.populate(resultObject, resultMap);
				resultList.add(resultObject);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtils.closeConnection(conn);
		}
		return resultList;
	}

	public <T> void deleteById(T clazz, Long id) {
	}

	public <T> void updateById(T clazz, Long id) {
	}

	public <T> Boolean save(T transientObject) {
		final String insertSql = getBtSqlPlain(transientObject.getClass().getName()).getInsertSql();
		PreparedStatement st;
		Boolean returnStatus = false;
		try {
			st = conn.prepareStatement(insertSql);
			int index = 1;
			for (BluetechnologyMapping.Class.Property property : getBtSqlPlain(transientObject.getClass().getName()).getMappingProperty()) {
				final String columnValue = BeanUtils.getProperty(transientObject, property.getName());
				st.setObject(index++, columnValue);
			}
			st.executeUpdate();
			returnStatus = true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return returnStatus;
	}

	@SuppressWarnings("unchecked")
	public <T> T findById(Class<T> clazz, Long id) {
		final String querySql = getBtSqlPlain(clazz.getName()).getQuerySql(new String[] { mapping.getClazz().getId().getColumn() });
		PreparedStatement st;
		T resultObject = null;
		try {
			st = conn.prepareStatement(querySql);
			st.setObject(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Map<String, Object> resultMap = new HashMap<String, Object>();
				for (BluetechnologyMapping.Class.Property property : getBtSqlPlain(clazz.getName()).getMappingProperty()) {
					resultMap.put(property.getName(), rs.getObject(property.getColumn()));
				}
				resultObject = (T) (Class.forName(clazz.getName()).newInstance());
				BeanUtils.populate(resultObject, resultMap);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
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
		catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtils.closeConnection(conn);
		}
		return resultObject;
	}

	private <T> BtSqlPlain<T> getBtSqlPlain(String className) {
		return new BtSqlPlain<T>(mapping, className);
	}
}
