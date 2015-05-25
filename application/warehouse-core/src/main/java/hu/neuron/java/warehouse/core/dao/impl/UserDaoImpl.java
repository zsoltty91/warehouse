package hu.neuron.java.warehouse.core.dao.impl;

import hu.neuron.java.warehouse.core.dao.UserDao;
import hu.neuron.java.warehouse.core.entity.User;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public User findUserByName(String name) {
		User user;
		try {
			Query query = entityManager.createNamedQuery("findUserByName",
					entityClass);
			query.setParameter("name", name);

			user = (User) query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
		return user;
	}


}
