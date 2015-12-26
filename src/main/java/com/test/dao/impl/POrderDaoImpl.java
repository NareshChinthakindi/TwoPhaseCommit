package com.test.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.test.dao.POrderDao;
import com.test.ordprocessmodel.POrder;

public class POrderDaoImpl extends HibernateDaoSupport implements POrderDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionfactory() {
		return sessionFactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionFactory = sessionfactory;
	}

	public int save(POrder order) {
		getHibernateTemplate().save(order);
		return order.getOrderId();
	}

	public POrder get(Integer id) {
		return (POrder) getHibernateTemplate()
				.load(POrder.class, id);
	}

	public void update(POrder order) {
		getHibernateTemplate().update(order);
	}
}
