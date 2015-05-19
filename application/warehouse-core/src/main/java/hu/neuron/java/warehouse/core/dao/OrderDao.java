package hu.neuron.java.warehouse.core.dao;

import hu.neuron.java.warehouse.core.entity.Order;

import java.util.List;

public interface OrderDao extends BaseDAO<Order> {

	List<Order> findOrdersByWarehouse(Long warehouseId) throws Exception;
}
