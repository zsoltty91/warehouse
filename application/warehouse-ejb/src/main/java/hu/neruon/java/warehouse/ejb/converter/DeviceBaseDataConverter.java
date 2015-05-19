package hu.neruon.java.warehouse.ejb.converter;

import hu.neruon.java.warehouse.ejb.client.vo.DeviceBasedataVO;
import hu.neuron.java.warehouse.core.entity.DeviceBasedata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeviceBaseDataConverter {

	public static DeviceBasedataVO toVO(DeviceBasedata entity) {
		DeviceBasedataVO vo = new DeviceBasedataVO();

		vo.setId(entity.getId());
		vo.setDescription(entity.getDescription());
		vo.setManufacturer(entity.getManufacturer());
		vo.setType(entity.getType());
		vo.setVisible(entity.getVisible());

		vo.setProperties(DevicePropertyConverter.toVO(entity.getProperties()));

		return vo;
	}

	public static List<DeviceBasedataVO> toVO(Collection<DeviceBasedata> entities) {
		List<DeviceBasedataVO> vos = new ArrayList<>();

		for (DeviceBasedata dto : entities) {
			vos.add(toVO(dto));
		}

		return vos;
	}

	public static DeviceBasedata toEntity(DeviceBasedataVO vo) {
		DeviceBasedata entity = new DeviceBasedata();

		entity.setId(vo.getId());
		entity.setDescription(vo.getDescription());
		entity.setManufacturer(vo.getManufacturer());
		entity.setType(vo.getType());
		entity.setVisible(vo.getVisible());

		entity.setProperties(DevicePropertyConverter.toEntity(vo.getProperties()));

		return entity;
	}

	public static List<DeviceBasedata> toEntity(Collection<DeviceBasedataVO> vos) {
		List<DeviceBasedata> entities = new ArrayList<>();

		for (DeviceBasedataVO vo : vos) {
			entities.add(toEntity(vo));
		}

		return entities;
	}
}
