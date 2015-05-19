package hu.neuron.java.warehouse.core.dao.impl;

import hu.neuron.java.warehouse.core.dao.DeviceWarehouseInfoDao;
import hu.neuron.java.warehouse.core.entity.DeviceWarehouseInfo;

import java.util.Collection;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class DeviceWarehouseInfoDaoImpl extends BaseDaoImpl<DeviceWarehouseInfo> implements DeviceWarehouseInfoDao{

	@Override
	public Collection<DeviceWarehouseInfo> findDeviceWarehouseInfosByWarehouse(
			Long warehouseId) throws Exception {
		Collection<DeviceWarehouseInfo> ret = null;
		try {
			Query query = entityManager.createNativeQuery("SELECT dwi FROM device_warehouse_info dwi WHERE dwi.warehouse_fk = :pWarehouseId",
					entityClass);
			query.setParameter("pWarehouseId", warehouseId);

			ret = (Collection<DeviceWarehouseInfo>) query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
		return ret;
	}

}
