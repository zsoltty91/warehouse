package hu.neuron.java.warehouse.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.neuron.java.warehouse.common.dao.DeviceBasedataDao;
import hu.neuron.java.warehouse.common.dao.DevicePropertyDao;
import hu.neuron.java.warehouse.common.dto.DeviceBaseDataDTO;
import hu.neuron.java.warehouse.common.dto.DevicePropertyDTO;
import hu.neuron.java.warehouse.common.dto.PropertyDTO;
import hu.neuron.java.warehouse.core.entity.DeviceBasedata;
import hu.neuron.java.warehouse.core.entity.DeviceProperty;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class DeviceBasedataDaoImpl extends BaseDaoImpl<DeviceBasedata, DeviceBaseDataDTO> implements DeviceBasedataDao {

	@Autowired
	DevicePropertyDao devicePropertyDao;

	@Override
	public DeviceBasedata toEntity(DeviceBaseDataDTO dto, DeviceBasedata entity) {
		if (dto == null || dto.getId() == null) {
			return new DeviceBasedata();
		}
		entity.setId(dto.getId());
		entity.setDescription(dto.getDescription());
		entity.setManufacturer(dto.getManufacturer());
		entity.setType(dto.getType());
		entity.setVisible(dto.getVisible());
		return entity;
	}

	@Override
	public DeviceBaseDataDTO toDto(DeviceBasedata entity) {
		if (entity == null) {
			return new DeviceBaseDataDTO();
		}

		List<DevicePropertyDTO> properties = null;
		if (entity.getProperties() != null) {
			properties = new ArrayList<>();

			DevicePropertyDTO devicePropertyDTO = null;
			PropertyDTO propertyDTO = null;
			for (DeviceProperty property : entity.getProperties()) {
				devicePropertyDTO = new DevicePropertyDTO();

				devicePropertyDTO.setId(property.getId());
				devicePropertyDTO.setValue(property.getValue());
				if (property.getProperty() != null) {
					propertyDTO = new PropertyDTO();
					propertyDTO.setId(property.getProperty().getId());
					propertyDTO.setName(property.getProperty().getName());
					devicePropertyDTO.setProperty(propertyDTO);
				}

				properties.add(devicePropertyDTO);
			}
		}

		DeviceBaseDataDTO deviceBasedataDTO = new DeviceBaseDataDTO(entity.getId(), entity.getManufacturer(),
				entity.getType(), entity.getDescription(), entity.getVisible(), properties);
		return deviceBasedataDTO;
	}

}
