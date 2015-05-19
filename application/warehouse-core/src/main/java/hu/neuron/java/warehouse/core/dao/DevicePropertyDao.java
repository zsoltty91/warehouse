package hu.neuron.java.warehouse.core.dao;


import hu.neuron.java.warehouse.core.entity.DeviceProperty;

import java.util.Collection;

public interface DevicePropertyDao extends BaseDAO<DeviceProperty> {

	Collection<DeviceProperty> findDevicePropertyByDeviceBasedata(Long id);
}
