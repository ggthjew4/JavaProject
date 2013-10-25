package com.bt;

import com.bt.connection.ConnectionUtils;
import com.bt.session.BtHibernateSession;
import com.bt.session.impl.BtHibernateSessionImpl;

public class BtMainPlaform {
	public static BtHibernateSession openSession() {
		return new BtHibernateSessionImpl(ConnectionUtils.getConnection());
	}
}
