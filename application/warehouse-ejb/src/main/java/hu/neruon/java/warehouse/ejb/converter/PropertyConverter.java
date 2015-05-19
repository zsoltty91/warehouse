package hu.neruon.java.warehouse.ejb.converter;

import hu.neruon.java.warehouse.ejb.client.vo.PropertyVO;
import hu.neuron.java.warehouse.core.entity.Property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PropertyConverter {
	public static PropertyVO toVO(Property entity) {
		PropertyVO vo = new PropertyVO();

		vo.setId(entity.getId());
		vo.setName(entity.getName());

		return vo;
	}

	public static List<PropertyVO> toVO(List<Property> entities) {
		List<PropertyVO> vos = new ArrayList<>();

		for (Property entity : entities) {
			vos.add(toVO(entity));
		}

		return vos;
	}

	public static Property toEntity(PropertyVO vo) {
		Property entity = new Property();

		entity.setId(vo.getId());
		entity.setName(vo.getName());

		return entity;
	}

	public static List<Property> toentity(Collection<PropertyVO> vos) {
		List<Property> entities = new ArrayList<>();

		for (PropertyVO vo : vos) {
			entities.add(toEntity(vo));
		}

		return entities;
	}
}
