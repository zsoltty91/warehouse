package hu.neuron.java.warehouse.core.dao.impl;

import hu.neuron.java.warehouse.core.dao.PropertyDao;
import hu.neuron.java.warehouse.core.entity.Property;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class PropertyDaoImpl extends BaseDaoImpl<Property> implements
		PropertyDao {

	@Override
	public Property findPropertyByName(String name) throws Exception {
		Property property;
		try {
			Query query = entityManager.createNamedQuery("findPropertyByName",
					entityClass);
			query.setParameter("pName", name);

			property = (Property) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return property;
	}

}
