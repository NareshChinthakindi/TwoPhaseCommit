package com.test.dao;

import com.test.model.Order;

public interface OrderDao {
	public int save(Order order);
	public Order get(Integer id);
	public void update(Order order);
}
