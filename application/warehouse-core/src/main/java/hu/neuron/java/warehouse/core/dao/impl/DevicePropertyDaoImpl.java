package hu.neuron.java.warehouse.core.dao.impl;

import hu.neuron.java.warehouse.common.dao.DevicePropertyDao;
import hu.neuron.java.warehouse.common.dto.DevicePropertyDTO;
import hu.neuron.java.warehouse.common.dto.PropertyDTO;
import hu.neuron.java.warehouse.core.entity.DeviceProperty;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class DevicePropertyDaoImpl extends BaseDaoImpl<DeviceProperty, DevicePropertyDTO> implements DevicePropertyDao {

	@Override
	public DeviceProperty toEntity(DevicePropertyDTO dto, DeviceProperty entity) {
		if (dto == null || dto.getId() == null) {
			return new DeviceProperty();
		}
		entity.setId(dto.getId());
		entity.setValue(dto.getValue());
		// if (dto.getProperty() != null && dto.getProperty().getId() != null) {
		// Property property = new Property();
		// property.setId(dto.getProperty().getId());
		// property.setName(dto.getProperty().getName());
		// entity.setProperty(property);
		// }

		return entity;
	}

	@Override
	public DevicePropertyDTO toDto(DeviceProperty entity) {
		if (entity == null) {
			return new DevicePropertyDTO();
		}

		PropertyDTO property = null;
		if (entity.getProperty() != null) {
			property = new PropertyDTO();
			property.setId(entity.getProperty().getId());
			property.setName(entity.getProperty().getName());
		}

		DevicePropertyDTO devicePropertyDTO = new DevicePropertyDTO(entity.getId(), entity.getValue(), property);
		return devicePropertyDTO;
	}

	@Override
	public Collection<DevicePropertyDTO> findDevicePropertyByDeviceBasedata(Long id) {
		ArrayList<DevicePropertyDTO> propertyDtos = new ArrayList<>();
		try {
			Query query = entityManager.createNativeQuery("SELECT p FROM device_property p  WHERE p.device_base_fk = :pDeviceBaseDataId", entityClass);
			query.setParameter("pDeviceBaseDataId", id);

			ArrayList<DeviceProperty> properties = (ArrayList<DeviceProperty>) query.getResultList();
			for (DeviceProperty property : properties) {
				propertyDtos.add(toDto(property));
			}
		} catch (NoResultException e) {
			return null;
		}
		return propertyDtos;
	}

}
