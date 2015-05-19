package hu.neruon.java.warehouse.ejb.converter;

import hu.neruon.java.warehouse.ejb.client.vo.DeviceWarehouseInfoVO;
import hu.neuron.java.warehouse.core.entity.DeviceWarehouseInfo;

import java.util.ArrayList;
import java.util.List;

public class DeviceWarehouseInfoConverter {
	public static DeviceWarehouseInfo toEntity(DeviceWarehouseInfoVO vo) {
		DeviceWarehouseInfo entity = new DeviceWarehouseInfo();

		entity.setCount(vo.getCount());
		entity.setDeviceBasedata(DeviceBaseDataConverter.toEntity(vo.getDeviceBasedata()));
		entity.setId(vo.getId());
		entity.setWarehouse(WarehouseConverter.toEntity(vo.getWarehouse()));

		return entity;
	}

	public static List<DeviceWarehouseInfo> toEntity(List<DeviceWarehouseInfoVO> vos) {
		List<DeviceWarehouseInfo> entities = new ArrayList<DeviceWarehouseInfo>();

		for (DeviceWarehouseInfoVO vo : vos) {
			entities.add(toEntity(vo));
		}

		return entities;
	}

	public static DeviceWarehouseInfoVO toVO(DeviceWarehouseInfo entity) {
		DeviceWarehouseInfoVO vo = new DeviceWarehouseInfoVO();

		vo.setCount(entity.getCount());
		vo.setDeviceBasedata(DeviceBaseDataConverter.toVO(entity.getDeviceBasedata()));
		vo.setId(entity.getId());
		vo.setWarehouse(WarehouseConverter.toVO(entity.getWarehouse()));

		return vo;
	}

	public static List<DeviceWarehouseInfoVO> toVO(List<DeviceWarehouseInfo> entities) {
		List<DeviceWarehouseInfoVO> vos = new ArrayList<DeviceWarehouseInfoVO>();

		for (DeviceWarehouseInfo entity : entities) {
			vos.add(toVO(entity));
		}

		return vos;
	}
}
