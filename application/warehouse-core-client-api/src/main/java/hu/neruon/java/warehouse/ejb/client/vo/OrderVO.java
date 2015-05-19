package hu.neruon.java.warehouse.ejb.client.vo;

import java.io.Serializable;
import java.util.Collection;

public class OrderVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String customerName;

	private String orderIdentifier;

	private Boolean completed;

	private WarehouseVO warehouse;

	private Collection<OrderItemVO> orderItems;

	public String getCustomerName() {
		return customerName;
	}

	public Collection<OrderItemVO> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Collection<OrderItemVO> orderItems) {
		this.orderItems = orderItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOrderIdentifier() {
		return orderIdentifier;
	}

	public void setOrderIdentifier(String orderIdentifier) {
		this.orderIdentifier = orderIdentifier;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public WarehouseVO getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(WarehouseVO warehouse) {
		this.warehouse = warehouse;
	}
}
