package hu.neuron.java.warehouse.core.dao.impl;

import hu.neuron.java.warehouse.common.dao.PropertyDao;
import hu.neuron.java.warehouse.common.dto.PropertyDTO;
import hu.neuron.java.warehouse.core.entity.Property;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class PropertyDaoImpl extends BaseDaoImpl<Property, PropertyDTO> implements
		BaseConvertDao<Property, PropertyDTO>, PropertyDao {

	@Override
	public PropertyDTO findPropertyByName(String name) throws Exception {
		Property property;
		try {
			Query query = entityManager.createNamedQuery("findPropertyByName", entityClass);
			query.setParameter("pName", name);

			property = (Property) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return toDto(property);
	}

	@Override
	public Property toEntity(PropertyDTO dto, Property entity) {
		if (dto == null) {
			return new Property();
		}
		if (entity == null) {
			entity = new Property();
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

		PropertyDTO propertyDTO = new PropertyDTO(entity.getName(), entity.getId());
		return propertyDTO;
	}

}
