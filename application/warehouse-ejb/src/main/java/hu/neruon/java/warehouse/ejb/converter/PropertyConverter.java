package hu.neruon.java.warehouse.ejb.converter;

import hu.neruon.java.warehouse.ejb.client.vo.PropertyVO;
import hu.neuron.java.warehouse.core.entity.Property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PropertyConverter {
	public static PropertyVO toVO(Property dto) {
		PropertyVO vo = new PropertyVO();

		vo.setId(dto.getId());
		vo.setName(dto.getName());

		return vo;
	}

	public static List<PropertyVO> toVO(List<Property> dtos) {
		List<PropertyVO> vos = new ArrayList<>();

		for (Property dto : dtos) {
			vos.add(toVO(dto));
		}

		return vos;
	}

	public static Property toDTO(PropertyVO vo) {
		Property dto = new Property();

		dto.setId(vo.getId());
		dto.setName(vo.getName());

		return dto;
	}

	public static List<Property> toDTO(Collection<PropertyVO> vos) {
		List<Property> dtos = new ArrayList<>();

		for (PropertyVO vo : vos) {
			dtos.add(toDTO(vo));
		}

		return dtos;
	}
}
