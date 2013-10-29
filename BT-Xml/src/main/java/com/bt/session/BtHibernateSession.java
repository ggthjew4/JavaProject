package com.bt.session;

import java.util.List;

import com.bt.xml.sql.impl.BtSqlPlain;

public interface BtHibernateSession {
	public <T> List<T> list(final Class<T> clazz);

	public <T> T findById(final Class<T> clazz, final Long id);

	public <T> void delete(final T persistentObject);

	public <T> void update(final T persistentObject);

	public <T> void save(final T transientObject);

	public void close();

	public <T> BtSqlPlain<T> getBtSqlPlain(String className);
}
