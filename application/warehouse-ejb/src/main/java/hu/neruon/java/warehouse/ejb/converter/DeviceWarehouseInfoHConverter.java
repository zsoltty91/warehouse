package hu.neruon.java.warehouse.ejb.converter;

import hu.neruon.java.warehouse.ejb.client.vo.DeviceWarehouseInfoHVO;
import hu.neuron.java.warehouse.core.entity.DeviceWarehouseInfoH;

import java.util.ArrayList;
import java.util.List;

public class DeviceWarehouseInfoHConverter {
	public static DeviceWarehouseInfoH toEntity(DeviceWarehouseInfoHVO vo) {
		DeviceWarehouseInfoH entity = new DeviceWarehouseInfoH();

		entity.setCount(vo.getCount());
		entity.setDeviceWarehouseInfo(DeviceWarehouseInfoConverter.toEntity(vo.getDeviceWarehouseInfo()));
		entity.setId(vo.getId());
		entity.setUser(UserConverter.toEntity(vo.getUser()));
		entity.setCreateDate(vo.getCreateDate());

		return entity;
	}

	public static List<DeviceWarehouseInfoH> toEntity(List<DeviceWarehouseInfoHVO> vos) {
		List<DeviceWarehouseInfoH> entities = new ArrayList<DeviceWarehouseInfoH>();

		for (DeviceWarehouseInfoHVO vo : vos) {
			entities.add(toEntity(vo));
		}

		return entities;
	}

	public static DeviceWarehouseInfoHVO toVO(DeviceWarehouseInfoH entity) {
		DeviceWarehouseInfoHVO vo = new DeviceWarehouseInfoHVO();

		vo.setCount(entity.getCount());
		vo.setDeviceWarehouseInfo(DeviceWarehouseInfoConverter.toVO(entity.getDeviceWarehouseInfo()));
		vo.setId(entity.getId());
		vo.setUser(UserConverter.toVO(entity.getUser()));
		vo.setCreateDate(entity.getCreateDate());

		return vo;
	}

	public static List<DeviceWarehouseInfoHVO> toVO(List<DeviceWarehouseInfoH> entities) {
		List<DeviceWarehouseInfoHVO> vos = new ArrayList<DeviceWarehouseInfoHVO>();

		for (DeviceWarehouseInfoH entity : entities) {
			vos.add(toVO(entity));
		}

		return vos;
	}
}
