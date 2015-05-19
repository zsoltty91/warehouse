package hu.neruon.java.warehouse.ejb.converter;

import hu.neruon.java.warehouse.ejb.client.vo.OrderItemVO;
import hu.neuron.java.warehouse.core.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderItemConverter {
	public static OrderItem toEntity(OrderItemVO vo) {
		OrderItem entity = new OrderItem();

		entity.setId(vo.getId());
		entity.setCount(vo.getCount());
		entity.setDeviceBasedata(DeviceBaseDataConverter.toEntity(vo.getDeviceBasedata()));

		return entity;
	}

	public static List<OrderItem> toEntity(List<OrderItemVO> vos) {
		List<OrderItem> entities = new ArrayList<OrderItem>();

		for (OrderItemVO vo : vos) {
			entities.add(toEntity(vo));
		}

		return entities;
	}

	public static OrderItemVO toVO(OrderItem entity) {
		OrderItemVO vo = new OrderItemVO();

		vo.setId(entity.getId());
		vo.setCount(entity.getCount());
		vo.setDeviceBasedata(DeviceBaseDataConverter.toVO(entity.getDeviceBasedata()));

		return vo;
	}

	public static List<OrderItemVO> toVO(List<OrderItem> entities) {
		List<OrderItemVO> vos = new ArrayList<OrderItemVO>();

		for (OrderItem entity : entities) {
			vos.add(toVO(entity));
		}

		return vos;
	}
}
