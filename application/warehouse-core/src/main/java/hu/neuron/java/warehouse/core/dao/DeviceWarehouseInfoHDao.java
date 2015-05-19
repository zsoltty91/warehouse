package hu.neuron.java.warehouse.core.dao;

import hu.neuron.java.warehouse.core.entity.DeviceWarehouseInfoH;

import java.util.Collection;

public interface DeviceWarehouseInfoHDao extends BaseDAO<DeviceWarehouseInfoH>{
	
	Collection<DeviceWarehouseInfoH> findDeviceWarehouseInfoHsByWarehouse(Long warehouseId) throws Exception;
	Collection<DeviceWarehouseInfoH> findDeviceWarehouseInfoHsByDeviceWarehouseInfo(Long deviceWarehouseInfoId) throws Exception;
	
}
