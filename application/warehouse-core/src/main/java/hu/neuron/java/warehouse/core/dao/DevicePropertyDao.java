package hu.neuron.java.warehouse.core.dao;


import hu.neuron.java.warehouse.core.entity.DeviceProperty;

import java.util.List;

public interface DevicePropertyDao extends BaseDAO<DeviceProperty> {

	List<DeviceProperty> findDevicePropertyByDeviceBasedata(Long id);
}
