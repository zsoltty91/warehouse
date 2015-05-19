package hu.neruon.java.warehouse.ejb.client.service;

import hu.neruon.java.warehouse.ejb.client.vo.OrderVO;
import hu.neruon.java.warehouse.ejb.client.vo.WarehouseVO;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface WarehouseServiceFacadeBeanRemote {

	public List<WarehouseVO> findAllWarehouse() throws Exception;

	public List<WarehouseVO> createWarehouses(List<WarehouseVO> warehouses) throws Exception;

	public List<OrderVO> findOrdersByWarehouse(Long warehouseId) throws Exception;

	public List<OrderVO> createOrders(List<OrderVO> orders) throws Exception;

	public OrderVO completeOrder(Long orderId) throws Exception;
	
}