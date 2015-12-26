package com.test.dao.impl;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.test.dao.OrderDao;
import com.test.model.Order;
import com.test.model.OrderItem;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao{
	
	private SessionFactory sessionfactory;
		
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	public int save(Order order) {
		getHibernateTemplate().save(order);
		
		return order.getOrderId();
	}

	public Order get(Integer id) {
		Order o=(Order) getHibernateTemplate().get(Order.class, id);
		return o;
	}
	
	public void update(Order order) {
		getHibernateTemplate().update(order);
	}

}
