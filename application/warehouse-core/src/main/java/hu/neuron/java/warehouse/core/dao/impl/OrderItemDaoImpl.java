package hu.neuron.java.warehouse.core.dao.impl;

import hu.neuron.java.warehouse.core.dao.OrderItemDao;
import hu.neuron.java.warehouse.core.entity.OrderItem;

import java.util.Collection;

import javax.persistence.NoResultException;
import javax.persistence.Query;

public class OrderItemDaoImpl extends BaseDaoImpl<OrderItem> implements OrderItemDao {

	@Override
	public Collection<OrderItem> findOrderItemByOrder(Long orderId) throws Exception {
		Collection<OrderItem> items = null;
		try {
			Query query = entityManager.createNativeQuery("SELECT o FROM order_item o WHERE o.order_fk = :pOrderId",
					entityClass);
			query.setParameter("pOrderId", orderId);

			items = (Collection<OrderItem>) query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
		return items;
	}
}
