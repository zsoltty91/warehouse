package hu.neruon.java.warehouse.ejb.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.neruon.java.warehouse.ejb.client.vo.DevicePropertyVO;
import hu.neuron.java.warehouse.common.dto.DevicePropertyDTO;

public class DevicePropertyConverter {
	public static DevicePropertyVO toVO(DevicePropertyDTO dto) {
		DevicePropertyVO vo = new DevicePropertyVO();

		vo.setId(dto.getId());
		vo.setValue(dto.getValue());

		vo.setProperty(PropertyConverter.toVO(dto.getProperty()));

		return vo;
	}

	public static List<DevicePropertyVO> toVO(Collection<DevicePropertyDTO> dtos) {
		List<DevicePropertyVO> vos = new ArrayList<>();

		for (DevicePropertyDTO dto : dtos) {
			vos.add(toVO(dto));
		}

		return vos;
	}

	public static DevicePropertyDTO toDTO(DevicePropertyVO vo) {
		DevicePropertyDTO dto = new DevicePropertyDTO();

		dto.setId(vo.getId());
		dto.setValue(vo.getValue());

		dto.setProperty(PropertyConverter.toDTO(vo.getProperty()));

		return dto;
	}

	public static List<DevicePropertyDTO> toDTO(Collection<DevicePropertyVO> vos) {
		List<DevicePropertyDTO> dtos = new ArrayList<>();

		for (DevicePropertyVO vo : vos) {
			dtos.add(toDTO(vo));
		}

		return dtos;
	}
}
