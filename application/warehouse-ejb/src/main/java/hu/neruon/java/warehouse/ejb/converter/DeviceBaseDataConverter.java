package hu.neruon.java.warehouse.ejb.converter;

import hu.neruon.java.warehouse.ejb.client.vo.DeviceBasedataVO;
import hu.neuron.java.warehouse.core.entity.DeviceBasedata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeviceBaseDataConverter {

	public static DeviceBasedataVO toVO(DeviceBasedata dto) {
		DeviceBasedataVO vo = new DeviceBasedataVO();

		vo.setId(dto.getId());
		vo.setDescription(dto.getDescription());
		vo.setManufacturer(dto.getManufacturer());
		vo.setType(dto.getType());
		vo.setVisible(dto.getVisible());

		vo.setProperties(DevicePropertyConverter.toVO(dto.getProperties()));

		return vo;
	}

	public static List<DeviceBasedataVO> toVO(Collection<DeviceBasedata> dtos) {
		List<DeviceBasedataVO> vos = new ArrayList<>();

		for (DeviceBasedata dto : dtos) {
			vos.add(toVO(dto));
		}

		return vos;
	}

	public static DeviceBasedata toDTO(DeviceBasedataVO vo) {
		DeviceBasedata dto = new DeviceBasedata();

		dto.setId(vo.getId());
		dto.setDescription(vo.getDescription());
		dto.setManufacturer(vo.getManufacturer());
		dto.setType(vo.getType());
		dto.setVisible(vo.getVisible());

		dto.setProperties(DevicePropertyConverter.toDTO(vo.getProperties()));

		return dto;
	}

	public static List<DeviceBasedata> toDTO(Collection<DeviceBasedataVO> vos) {
		List<DeviceBasedata> dtos = new ArrayList<>();

		for (DeviceBasedataVO vo : vos) {
			dtos.add(toDTO(vo));
		}

		return dtos;
	}
}
