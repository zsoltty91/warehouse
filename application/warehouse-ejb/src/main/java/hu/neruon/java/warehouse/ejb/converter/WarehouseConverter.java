package hu.neruon.java.warehouse.ejb.converter;

import hu.neruon.java.warehouse.ejb.client.vo.WarehouseVO;
import hu.neuron.java.warehouse.core.entity.Warehouse;

import java.util.ArrayList;
import java.util.List;

public class WarehouseConverter {
	public static Warehouse toEntity(WarehouseVO vo) {
		Warehouse entity = new Warehouse();
		
		if(vo != null){
			entity.setAddressCity(vo.getAddressCity());
			entity.setAddressCountry(vo.getAddressCountry());
			entity.setAddressPostcode(vo.getAddressPostcode());
			entity.setAddressStreet(vo.getAddressStreet());
			entity.setId(vo.getId());
			entity.setManagers(UserConverter.toEntity(vo.getManagers()));
			entity.setName(vo.getName());
			entity.setNumber(vo.getNumber());
			entity.setWorkers(UserConverter.toEntity(vo.getWorkers()));
		}
		
		return entity;
	}

	public static List<Warehouse> toEntity(List<WarehouseVO> vos) {
		List<Warehouse> entities = new ArrayList<Warehouse>();

		for (WarehouseVO vo : vos) {
			entities.add(toEntity(vo));
		}

		return entities;
	}

	public static WarehouseVO toVO(Warehouse entity) {
		WarehouseVO vo = new WarehouseVO();

		vo.setAddressCity(entity.getAddressCity());
		vo.setAddressCountry(entity.getAddressCountry());
		vo.setAddressPostcode(entity.getAddressPostcode());
		vo.setAddressStreet(entity.getAddressStreet());
		vo.setId(entity.getId());
		vo.setManagers(UserConverter.toVO(entity.getManagers()));
		vo.setName(entity.getName());
		vo.setNumber(entity.getNumber());
		vo.setWorkers(UserConverter.toVO(entity.getWorkers()));

		return vo;
	}

	public static List<WarehouseVO> toVO(List<Warehouse> entities) {
		List<WarehouseVO> vos = new ArrayList<WarehouseVO>();

		for (Warehouse entity : entities) {
			vos.add(toVO(entity));
		}

		return vos;
	}
}
