package hu.neuron.java.warehouse.core.dao;

import hu.neuron.java.warehouse.core.entity.DeviceWarehouseInfo;

import java.util.List;

public interface DeviceWarehouseInfoDao extends BaseDAO<DeviceWarehouseInfo>{
	
	List<DeviceWarehouseInfo> findDeviceWarehouseInfosByWarehouse(Long warehouseId) throws Exception;
	
}
