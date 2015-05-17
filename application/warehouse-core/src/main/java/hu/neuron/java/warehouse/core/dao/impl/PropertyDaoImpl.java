package hu.neuron.java.warehouse.core.dao.impl;

import hu.neuron.java.warehouse.common.dao.PropertyDao;
import hu.neuron.java.warehouse.common.dto.PropertyDTO;
import hu.neuron.java.warehouse.core.entity.Property;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation=Propagation.SUPPORTS)
public class PropertyDaoImpl extends BaseDaoImpl<Property, PropertyDTO>
		implements BaseConvertDao<Property, PropertyDTO>, PropertyDao {

	@Override
	public PropertyDTO findPropertyByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Property toEntity(PropertyDTO dto, Property entity) {
		if (dto == null || dto.getId() == null) {
			return new Property();
		}
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}

	@Override
	public PropertyDTO toDto(Property entity) {
		if (entity == null) {
			return new PropertyDTO();
		}

		PropertyDTO propertyDTO = new PropertyDTO(entity.getName(),
				entity.getId());
		return propertyDTO;
	}

}
