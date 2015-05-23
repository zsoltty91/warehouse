package hu.neruon.java.warehouse.ejb.converter;

import hu.neruon.java.warehouse.ejb.client.vo.DevicePropertyVO;
import hu.neuron.java.warehouse.core.entity.DeviceProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DevicePropertyConverter {
	public static DevicePropertyVO toVO(DeviceProperty entity) {
		DevicePropertyVO vo = new DevicePropertyVO();

		vo.setId(entity.getId());
		vo.setValue(entity.getValue());

		vo.setProperty(PropertyConverter.toVO(entity.getProperty()));

		return vo;
	}

	public static List<DevicePropertyVO> toVO(Collection<DeviceProperty> entities) {
		List<DevicePropertyVO> vos = new ArrayList<>();

		for (DeviceProperty entity : entities) {
			vos.add(toVO(entity));
		}

		return vos;
	}

	public static DeviceProperty toEntity(DevicePropertyVO vo) {
		DeviceProperty entity = new DeviceProperty();

		entity.setId(vo.getId());
		entity.setValue(vo.getValue());

		entity.setProperty(PropertyConverter.toEntity(vo.getProperty()));

		return entity;
	}

	public static List<DeviceProperty> toEntity(Collection<DevicePropertyVO> vos) {
		List<DeviceProperty> entities = new ArrayList<>();
		
		if(vos != null){
			for (DevicePropertyVO vo : vos) {
				entities.add(toEntity(vo));
			}
		}

		return entities;
	}
}
