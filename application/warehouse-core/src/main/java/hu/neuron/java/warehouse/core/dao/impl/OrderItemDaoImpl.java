package hu.neuron.java.warehouse.core.dao.impl;

import hu.neuron.java.warehouse.core.dao.OrderItemDao;
import hu.neuron.java.warehouse.core.entity.OrderItem;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

public class OrderItemDaoImpl extends BaseDaoImpl<OrderItem> implements OrderItemDao {

	@Override
	public List<OrderItem> findOrderItemByOrder(Long orderId) throws Exception {
		List<OrderItem> items = null;
		try {
			Query query = entityManager.createNativeQuery("SELECT o FROM order_item o WHERE o.order_fk = :pOrderId",
					entityClass);
			query.setParameter("pOrderId", orderId);

			items = (List<OrderItem>) query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
		return items;
	}
}
