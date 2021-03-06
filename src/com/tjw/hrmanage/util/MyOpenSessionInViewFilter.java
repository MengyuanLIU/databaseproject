package com.tjw.hrmanage.util;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.OpenSessionInViewFilter;

public class MyOpenSessionInViewFilter extends OpenSessionInViewFilter{
	protected Session getSession(SessionFactory sessionFactory) throws DataAccessResourceFailureException {
        Session session = SessionFactoryUtils.getSession(sessionFactory, true);
        session.setFlushMode(FlushMode.NEVER);
        return session;
}
/**
 * we do an explicit flush here just in case
 * we do not have an automated flush
 */
	protected void closeSession(Session session, SessionFactory factory) {
	        session.flush();
	        super.closeSession(session, factory);
	}
}
