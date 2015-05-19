package hu.neuron.java.warehouse.core.dao.impl;

import hu.neuron.java.warehouse.core.dao.WarehouseDao;
import hu.neuron.java.warehouse.core.entity.Warehouse;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class WarehouseDaoImpl extends BaseDaoImpl<Warehouse> implements WarehouseDao{

}
