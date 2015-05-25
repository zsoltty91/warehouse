package hu.neuron.java.warehouse.core.dao;

import hu.neuron.java.warehouse.core.entity.User;

public interface UserDao extends BaseDAO<User> {
	
	User findUserByName(String name);

}
