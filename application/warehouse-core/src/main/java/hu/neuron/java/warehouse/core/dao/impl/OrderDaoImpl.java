package hu.neuron.java.warehouse.core.dao.impl;

import hu.neuron.java.warehouse.core.dao.OrderDao;
import hu.neuron.java.warehouse.core.entity.Order;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {

	@Override
	public List<Order> findOrdersByWarehouse(Long warehouseId) throws Exception {
		List<Order> orders;
		try {
			Query query = entityManager.createNativeQuery("SELECT o FROM order o WHERE o.warehouse_fk = :pWarehouseId",
					entityClass);
			query.setParameter("pWarehouseId", warehouseId);

			orders = (List<Order>) query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
		return orders;
	}

}
