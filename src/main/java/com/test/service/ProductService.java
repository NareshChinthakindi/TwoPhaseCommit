package com.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.OrderDao;
import com.test.dao.POrderDao;
import com.test.model.Order;
import com.test.model.OrderItem;
import com.test.model.OrderStatus;
import com.test.ordprocessmodel.POrder;

public class ProductService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private POrderDao pOrderDao;

	@Transactional
	public void placeOrder() {
		
		//Creating an Order
		Order order = new Order();
		order.setOrderName("Naresh");
		order.setOrderDate(new Date());
		order.setOrderStatus(OrderStatus.PENDING);

		List<OrderItem> list = new ArrayList<OrderItem>();
		OrderItem item = new OrderItem();
		item.setName("ghee");
		item.setPrice(100.50);
		item.setQuantity(2);
		item.setOrder(order);
		list.add(item);

		item = new OrderItem();
		item.setName("butter");
		item.setPrice(10.50);
		item.setQuantity(2);
		item.setOrder(order);
		list.add(item);
		order.setItems(list);
		//Order creation complete
		
		//saving order in Order DB
		int id = orderDao.save(order);
		Order o = orderDao.get(id);
		System.out.println("order saved with orderid=" + id + " name=" + o.getOrderName());

		//Process Order saved
		OrderToProcessOrderMapper opm = new OrderToProcessOrderMapper();
		POrder po = opm.map(o);
		pOrderDao.save(po);

		// throwing runtime exception to test the transaction rollback
		if (!true)
			throw new RuntimeException("Error Occured");
		
		//Changed order status to delivered
		o.setOrderStatus(OrderStatus.DELIVERED);
		orderDao.update(o);
	}

}
