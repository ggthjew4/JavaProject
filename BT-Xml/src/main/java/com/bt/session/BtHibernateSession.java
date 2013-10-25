package com.bt.session;

import java.util.List;

public interface BtHibernateSession {
	public <T> List<T> list(final Class<T> clazz);

	public <T> T findById(final Class<T> clazz, final Long id);

	public <T> void deleteById(final T clazz, final Long id);

	public <T> void updateById(final T clazz, final Long id);
	
	public <T> Boolean save(final T transientObject);
}
