package com.test.service;

import java.util.ArrayList;
import java.util.List;

import com.test.model.Order;
import com.test.model.OrderItem;
import com.test.ordprocessmodel.POrder;
import com.test.ordprocessmodel.POrderItem;

public class OrderToProcessOrderMapper {
	public POrder map(Order o){
		POrder po=new POrder();
		
		po.setOrderDate(o.getOrderDate());
		po.setOriginalOrderId(o.getOrderId());
		po.setOrderName(o.getOrderName());
		
		POrderItem poi;
		List<POrderItem> list=new ArrayList<POrderItem>();
		for(OrderItem oi:o.getItems()){
			poi=new POrderItem();
			poi.setName(oi.getName());
			poi.setOrder(po);
			poi.setPrice(oi.getPrice());
			poi.setQuantity(oi.getQuantity());
			list.add(poi);
		}
		po.setItems(list);
		return po;
	}
}
