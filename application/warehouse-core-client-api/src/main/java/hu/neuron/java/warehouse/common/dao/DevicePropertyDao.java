package hu.neuron.java.warehouse.common.dao;

import java.util.Collection;

import hu.neuron.java.warehouse.common.dto.DevicePropertyDTO;

public interface DevicePropertyDao extends BaseDAO<DevicePropertyDTO> {

	Collection<DevicePropertyDTO> findDevicePropertyByDeviceBasedata(Long id);
}
