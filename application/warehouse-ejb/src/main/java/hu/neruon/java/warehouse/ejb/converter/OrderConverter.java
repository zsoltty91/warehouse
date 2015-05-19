package hu.neruon.java.warehouse.ejb.converter;

import hu.neruon.java.warehouse.ejb.client.vo.OrderVO;
import hu.neuron.java.warehouse.core.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderConverter {
	public static Order toEntity(OrderVO vo) {
		Order entity = new Order();

		entity.setCompleted(vo.getCompleted());
		entity.setCustomerName(vo.getCustomerName());
		entity.setId(vo.getId());
		entity.setOrderIdentifier(vo.getOrderIdentifier());
		entity.setWarehouse(WarehouseConverter.toEntity(vo.getWarehouse()));

		return entity;
	}

	public static List<Order> toEntity(List<OrderVO> vos) {
		List<Order> entities = new ArrayList<Order>();

		for (OrderVO vo : vos) {
			entities.add(toEntity(vo));
		}

		return entities;
	}

	public static OrderVO toVO(Order entity) {
		OrderVO vo = new OrderVO();

		vo.setCompleted(entity.getCompleted());
		vo.setCustomerName(entity.getCustomerName());
		vo.setId(entity.getId());
		vo.setOrderIdentifier(entity.getOrderIdentifier());
		vo.setWarehouse(WarehouseConverter.toVO(entity.getWarehouse()));

		return vo;
	}

	public static List<OrderVO> toVO(List<Order> entities) {
		List<OrderVO> vos = new ArrayList<OrderVO>();

		for (Order entity : entities) {
			vos.add(toVO(entity));
		}

		return vos;
	}
}
