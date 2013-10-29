package com.bt.session.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bt.connection.ConnectionUtils;
import com.bt.session.BtHibernateSession;
import com.bt.xml.BtXmlBinder;
import com.bt.xml.BtXmlParsingHelp;
import com.bt.xml.jaxb.BluetechnologyMapping;
import com.bt.xml.jaxb.BluetechnologyMapping.Class.Property;
import com.bt.xml.sql.impl.BtSqlPlain;

public class BtHibernateSessionImpl implements BtHibernateSession {
	private Connection						conn;
	private BluetechnologyMapping			mapping;
	private BtXmlBinder						xmlBinder;
	private final static ApplicationContext	SPRING_CONTEXT	= new ClassPathXmlApplicationContext("Spring-Configuration.xml");
	private final static Logger				logger			= Logger.getLogger(BtHibernateSessionImpl.class);

	public BtHibernateSessionImpl(Connection conn) {
		this.conn = conn;
		this.mapping = ((BtXmlParsingHelp) SPRING_CONTEXT.getBean("XMLConverter")).loadXMLFile("bt_hibernate.xml");
		this.xmlBinder = new BtXmlBinder();
	}

	public void close() {
		ConnectionUtils.closeConnection(conn);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> list(final Class<T> clazz) {
		final List<T> resultList = new ArrayList<T>();
		try {
			Statement st = ConnectionUtils.createStatement(conn);
			ResultSet rs = st.executeQuery(getBtSqlPlain(clazz.getName()).getQuerySql());
			while (rs.next()) {
				resultList.add((T) xmlBinder.bindElementToProperties(clazz, getBtSqlPlain(clazz.getName()), rs));
			}
		}
		catch (SQLException e) {
			logger.trace("ExecuteQuery occurs SQLException ", e);
		}
		return resultList;
	}

	public <T> void delete(T persistentObject) {
		final String deleteSql = getBtSqlPlain(persistentObject.getClass().getName()).getDeleteSql();
		PreparedStatement st;
		try {
			st = ConnectionUtils.createPrepareStatement(conn, deleteSql);
			st.setObject(1, BeanUtils.getProperty(persistentObject, getBtSqlPlain(persistentObject.getClass().getName()).getTargetTableIdName()));
			st.executeUpdate();
		}
		catch (Exception e) {
			logger.trace("occurs Exception ", e);
		}
	}

	public <T> void update(T persistentObject) {
		final String updateSql = getBtSqlPlain(persistentObject.getClass().getName()).getUpdateSql();
		PreparedStatement st;
		try {
			st = ConnectionUtils.createPrepareStatement(conn, updateSql);
			int index = 1;
			for (Property property : getBtSqlPlain(persistentObject.getClass().getName()).getMappingProperty()) {
				final String columnValue = BeanUtils.getProperty(persistentObject, property.getName());
				st.setObject(index++, columnValue);
			}
			st.setObject(index, BeanUtils.getProperty(persistentObject, getBtSqlPlain(persistentObject.getClass().getName()).getTargetTableIdName()));
			st.executeUpdate();
		}
		catch (Exception e) {
			logger.trace("occurs Exception ", e);
		}
	}

	public <T> void save(T transientObject) {
		final String insertSql = getBtSqlPlain(transientObject.getClass().getName()).getInsertSql();
		PreparedStatement st;
		try {
			st = ConnectionUtils.createPrepareStatement(conn, insertSql);
			int index = 1;
			for (Property property : getBtSqlPlain(transientObject.getClass().getName()).getMappingProperty()) {
				final String columnValue = BeanUtils.getProperty(transientObject, property.getName());
				st.setObject(index++, columnValue);
			}
			st.executeUpdate();
		}
		catch (Exception e) {
			logger.trace("occurs Exception ", e);
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T findById(Class<T> clazz, Long id) {
		final String querySql = getBtSqlPlain(clazz.getName()).getQuerySql(new String[] { mapping.getClazz().getId().getColumn() });
		PreparedStatement st;
		T resultObject = null;
		try {
			st = ConnectionUtils.createPrepareStatement(conn, querySql);
			st.setObject(1, id);
			final ResultSet rs = st.executeQuery();
			while (rs.next()) {
				resultObject = (T) xmlBinder.bindElementToProperties(clazz, getBtSqlPlain(clazz.getName()), rs);
			}
		}
		catch (SQLException e) {
			logger.trace("occurs Exception ", e);
		}
		return resultObject;
	}

	public <T> BtSqlPlain<T> getBtSqlPlain(String className) {
		return new BtSqlPlain<T>(mapping, className);
	}
}
