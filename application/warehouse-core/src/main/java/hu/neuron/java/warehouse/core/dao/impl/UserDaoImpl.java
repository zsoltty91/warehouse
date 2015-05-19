package hu.neuron.java.warehouse.core.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.neuron.java.warehouse.core.dao.UserDao;
import hu.neuron.java.warehouse.core.entity.User;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{


}
