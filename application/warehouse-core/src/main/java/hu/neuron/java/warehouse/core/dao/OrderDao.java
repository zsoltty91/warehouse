package hu.neuron.java.warehouse.core.dao;

import hu.neuron.java.warehouse.core.entity.Order;

import java.util.Collection;

public interface OrderDao extends BaseDAO<Order> {

	Collection<Order> findOrdersByWarehouse(Long warehouseId) throws Exception;
}
