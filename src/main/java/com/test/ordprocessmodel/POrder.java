package com.test.ordprocessmodel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="POrder")
@XmlRootElement
public class POrder implements Serializable {

	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	
	@Column
	private String orderName;
	
	@Column
	private Date orderDate;
	
	@Column
	private int originalOrderId;
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
	private List<POrderItem> items;
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	

	public int getOriginalOrderId() {
		return originalOrderId;
	}

	public void setOriginalOrderId(int originalOrderId) {
		this.originalOrderId = originalOrderId;
	}

	public List<POrderItem> getItems() {
		return items;
	}

	public void setItems(List<POrderItem> items) {
		this.items = items;
	}


	
	
}
