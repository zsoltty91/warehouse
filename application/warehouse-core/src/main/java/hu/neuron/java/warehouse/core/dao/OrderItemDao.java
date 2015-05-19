package hu.neuron.java.warehouse.core.dao;

import java.util.Collection;

import hu.neuron.java.warehouse.core.entity.OrderItem;

public interface OrderItemDao extends BaseDAO<OrderItem> {

	Collection<OrderItem> findOrderItemByOrder(Long orderId) throws Exception;
	
}
