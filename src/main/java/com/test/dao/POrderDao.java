package com.test.dao;

import com.test.model.Order;
import com.test.ordprocessmodel.POrder;

public interface POrderDao {
	public int save(POrder order);
	public POrder get(Integer id);
	public void update(POrder order);

}
