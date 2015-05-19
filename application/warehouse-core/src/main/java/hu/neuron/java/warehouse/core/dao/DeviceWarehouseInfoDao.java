package hu.neuron.java.warehouse.core.dao;

import hu.neuron.java.warehouse.core.entity.DeviceWarehouseInfo;

import java.util.Collection;

public interface DeviceWarehouseInfoDao extends BaseDAO<DeviceWarehouseInfo>{
	
	Collection<DeviceWarehouseInfo> findDeviceWarehouseInfosByWarehouse(Long warehouseId) throws Exception;
	
}
