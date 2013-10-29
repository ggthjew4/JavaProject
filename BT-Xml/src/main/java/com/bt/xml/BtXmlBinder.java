package com.bt.xml;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.bt.xml.jaxb.BluetechnologyMapping.Class.Property;
import com.bt.xml.sql.SqlPlain;

public class BtXmlBinder {
	private final static Logger	logger	= Logger.getLogger(BtXmlBinder.class);

	public <T> T bindElementToProperties(final Class<T> clazz, final SqlPlain sqlPlain, final ResultSet rs) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		T resultObject = null;
		for (Property property : sqlPlain.getMappingProperty()) {
			try {
				resultMap.put(property.getName(), rs.getObject(property.getColumn()));
				resultMap.put(sqlPlain.getTargetTableIdName(), rs.getObject(sqlPlain.getTargetTableIdColumnName()));
				resultObject = (T) (Class.forName(clazz.getName()).newInstance());
				BeanUtils.populate(resultObject, resultMap);
			}
			catch (SQLException e) {
				logger.trace("bindElementToProperties occures SQLException", e);
			}
			catch (IllegalAccessException e) {
				logger.trace("bindElementToProperties occures IllegalAccessException", e);
			}
			catch (InvocationTargetException e) {
				logger.trace("bindElementToProperties occures InvocationTargetException", e);
			}
			catch (InstantiationException e) {
				logger.trace("bindElementToProperties occures InstantiationException", e);
			}
			catch (ClassNotFoundException e) {
				logger.trace("bindElementToProperties occures ClassNotFoundException", e);
			}
		}
		return resultObject;
	}
}
