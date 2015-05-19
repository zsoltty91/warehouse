package hu.neuron.java.warehouse.core.dao.impl;

import hu.neuron.java.warehouse.core.dao.DevicePropertyDao;
import hu.neuron.java.warehouse.core.entity.DeviceProperty;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class DevicePropertyDaoImpl extends BaseDaoImpl<DeviceProperty>
		implements DevicePropertyDao {

	@Override
	public List<DeviceProperty> findDevicePropertyByDeviceBasedata(Long id) {
		ArrayList<DeviceProperty> propertyDtos = new ArrayList<>();
		try {
			Query query = entityManager
					.createNativeQuery(
							"SELECT p FROM device_property p  WHERE p.device_base_fk = :pDeviceBaseDataId",
							entityClass);
			query.setParameter("pDeviceBaseDataId", id);

			ArrayList<DeviceProperty> properties = (ArrayList<DeviceProperty>) query
					.getResultList();
			for (DeviceProperty property : properties) {
				propertyDtos.add(property);
			}
		} catch (NoResultException e) {
			return null;
		}
		return propertyDtos;
	}

}
