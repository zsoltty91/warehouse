package hu.neruon.java.warehouse.ejb.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.neruon.java.warehouse.ejb.client.vo.PropertyVO;
import hu.neuron.java.warehouse.common.dto.PropertyDTO;

public class PropertyConverter {
	public static PropertyVO toVO(PropertyDTO dto) {
		PropertyVO vo = new PropertyVO();

		vo.setId(dto.getId());
		vo.setName(dto.getName());

		return vo;
	}

	public static List<PropertyVO> toVO(List<PropertyDTO> dtos) {
		List<PropertyVO> vos = new ArrayList<>();

		for (PropertyDTO dto : dtos) {
			vos.add(toVO(dto));
		}

		return vos;
	}

	public static PropertyDTO toDTO(PropertyVO vo) {
		PropertyDTO dto = new PropertyDTO();

		dto.setId(vo.getId());
		dto.setName(vo.getName());

		return dto;
	}

	public static List<PropertyDTO> toDTO(Collection<PropertyVO> vos) {
		List<PropertyDTO> dtos = new ArrayList<>();

		for (PropertyVO vo : vos) {
			dtos.add(toDTO(vo));
		}

		return dtos;
	}
}
