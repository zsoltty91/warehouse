package hu.neuron.java.warehouse.core.dao;

import hu.neuron.java.warehouse.core.entity.OrderItem;

import java.util.List;

public interface OrderItemDao extends BaseDAO<OrderItem> {

	List<OrderItem> findOrderItemByOrder(Long orderId) throws Exception;
	
}
