package hu.neuron.java.warehouse.core.dao.impl;

import hu.neuron.java.warehouse.core.dao.DeviceWarehouseInfoHDao;
import hu.neuron.java.warehouse.core.entity.DeviceWarehouseInfoH;

import java.util.Collection;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class DeviceWarehouseInfoHDaoImpl extends BaseDaoImpl<DeviceWarehouseInfoH> implements DeviceWarehouseInfoHDao{

	@Override
	public Collection<DeviceWarehouseInfoH> findDeviceWarehouseInfoHsByWarehouse(
			Long warehouseId) throws Exception {
		Collection<DeviceWarehouseInfoH> ret = null;
		try {
			Query query = entityManager.createNativeQuery("SELECT dwih FROM device_warehouse_info_h dwih INNER JOIN device_warehouse_info dwi WHERE dwi.warehouse_fk = :pWarehouseId",
					entityClass);
			query.setParameter("pWarehouseId", warehouseId);

			ret = (Collection<DeviceWarehouseInfoH>) query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
		return ret;
	}

	@Override
	public Collection<DeviceWarehouseInfoH> findDeviceWarehouseInfoHsByDeviceWarehouseInfo(
			Long deviceWarehouseInfoId) throws Exception {
		Collection<DeviceWarehouseInfoH> ret = null;
		try {
			Query query = entityManager.createNativeQuery("SELECT dwih FROM device_warehouse_info_h dwih WHERE dwih.device_warehouse_info_fk = :pDeviceWarehouseInfoId",
					entityClass);
			query.setParameter("pDeviceWarehouseInfoId", deviceWarehouseInfoId);

			ret = (Collection<DeviceWarehouseInfoH>) query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
		return ret;
	}

}
