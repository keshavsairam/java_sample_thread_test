package com.sample.example.model;

import com.sample.example.util.StatusEnum;

public class Order {
	StatusEnum status;
	String ordnum;
	
	public Order () {
	}

	public Order(String name, StatusEnum status) {
		super();
		this.status = status;
		this.ordnum = ordnum;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getName() {
		return ordnum;
	}

	public void setOrdernum(String ordnum) {
		this.ordnum = ordnum;
	}

	@Override
	public String toString() {
		return "Order [status=" + status + ", ordnum=" + ordnum + "]";
	}
	

}
