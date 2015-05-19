package hu.neuron.java.warehouse.core.dao;

import hu.neuron.java.warehouse.core.entity.DeviceWarehouseInfoH;

import java.util.List;

public interface DeviceWarehouseInfoHDao extends BaseDAO<DeviceWarehouseInfoH>{
	
	List<DeviceWarehouseInfoH> findDeviceWarehouseInfoHsByWarehouse(Long warehouseId) throws Exception;
	List<DeviceWarehouseInfoH> findDeviceWarehouseInfoHsByDeviceWarehouseInfo(Long deviceWarehouseInfoId) throws Exception;
	
}
