package hu.neruon.java.warehouse.ejb.converter;

import hu.neruon.java.warehouse.ejb.client.vo.DevicePropertyVO;
import hu.neuron.java.warehouse.core.entity.DeviceProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DevicePropertyConverter {
	public static DevicePropertyVO toVO(DeviceProperty dto) {
		DevicePropertyVO vo = new DevicePropertyVO();

		vo.setId(dto.getId());
		vo.setValue(dto.getValue());

		vo.setProperty(PropertyConverter.toVO(dto.getProperty()));

		return vo;
	}

	public static List<DevicePropertyVO> toVO(Collection<DeviceProperty> dtos) {
		List<DevicePropertyVO> vos = new ArrayList<>();

		for (DeviceProperty dto : dtos) {
			vos.add(toVO(dto));
		}

		return vos;
	}

	public static DeviceProperty toDTO(DevicePropertyVO vo) {
		DeviceProperty dto = new DeviceProperty();

		dto.setId(vo.getId());
		dto.setValue(vo.getValue());

		dto.setProperty(PropertyConverter.toDTO(vo.getProperty()));

		return dto;
	}

	public static List<DeviceProperty> toDTO(Collection<DevicePropertyVO> vos) {
		List<DeviceProperty> dtos = new ArrayList<>();

		for (DevicePropertyVO vo : vos) {
			dtos.add(toDTO(vo));
		}

		return dtos;
	}
}
