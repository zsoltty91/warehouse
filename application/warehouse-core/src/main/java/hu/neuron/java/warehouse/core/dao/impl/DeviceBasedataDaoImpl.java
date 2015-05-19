package hu.neuron.java.warehouse.core.dao.impl;

import hu.neuron.java.warehouse.core.dao.DeviceBasedataDao;
import hu.neuron.java.warehouse.core.entity.DeviceBasedata;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class DeviceBasedataDaoImpl extends BaseDaoImpl<DeviceBasedata>
		implements DeviceBasedataDao {

}
