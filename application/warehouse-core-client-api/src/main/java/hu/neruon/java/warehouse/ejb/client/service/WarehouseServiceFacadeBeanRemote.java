package hu.neruon.java.warehouse.ejb.client.service;

import hu.neruon.java.warehouse.ejb.client.vo.DeviceBasedataVO;
import hu.neruon.java.warehouse.ejb.client.vo.DeviceWarehouseInfoHVO;
import hu.neruon.java.warehouse.ejb.client.vo.DeviceWarehouseInfoVO;
import hu.neruon.java.warehouse.ejb.client.vo.OrderVO;
import hu.neruon.java.warehouse.ejb.client.vo.WarehouseVO;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface WarehouseServiceFacadeBeanRemote {

	public List<WarehouseVO> findAllWarehouse() throws Exception;

	public List<WarehouseVO> createWarehouses(List<WarehouseVO> warehouses) throws Exception;
	
	public List<DeviceWarehouseInfoVO> findDeviceWarehouseInfos(Long warehouseId) throws Exception;
	
	public List<DeviceWarehouseInfoVO> createDeviceWarehouseInfos(List<DeviceWarehouseInfoVO> deviceWarehouseInfos) throws Exception;

	public List<DeviceWarehouseInfoHVO> findDeviceWarehouseInfoHs(Long warehouseId) throws Exception;
	
	public List<DeviceWarehouseInfoHVO> createDeviceWarehouseInfoHs(List<DeviceWarehouseInfoHVO> deviceWarehouseInfos) throws Exception;
	
	public List<OrderVO> findOrdersByWarehouse(Long warehouseId) throws Exception;

	public List<OrderVO> createOrders(List<OrderVO> orders) throws Exception;

	public OrderVO completeOrder(Long orderId) throws Exception;
	
	public List<DeviceBasedataVO> findAllDeviceBasedata() throws Exception;
}
