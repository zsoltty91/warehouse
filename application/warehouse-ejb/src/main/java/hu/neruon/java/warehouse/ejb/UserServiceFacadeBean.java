package hu.neruon.java.warehouse.ejb;

import hu.neruon.java.warehouse.ejb.client.service.UserServiceFacadeBeanLocal;
import hu.neruon.java.warehouse.ejb.client.service.UserServiceFacadeBeanRemote;
import hu.neruon.java.warehouse.ejb.client.vo.UserVO;
import hu.neruon.java.warehouse.ejb.converter.UserConverter;
import hu.neuron.java.warehouse.core.dao.UserDao;
import hu.neuron.java.warehouse.core.entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@Stateless(mappedName = "UserServiceFacadeBean")
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserServiceFacadeBean implements UserServiceFacadeBeanLocal, UserServiceFacadeBeanRemote{

	private static final Logger logger = Logger.getLogger(UserServiceFacadeBean.class);
	
	@Autowired
	UserDao userDao;
	
	@Override
	public List<UserVO> findAllUser() throws Exception {
		return UserConverter.toVO(userDao.findAll());
	}

	@Override
	public List<UserVO> createUsers(List<UserVO> users) throws Exception {
		
		List<UserVO> storedUsers = new ArrayList<UserVO>();
		
		if (users == null || users.isEmpty()) {
			return storedUsers;
		}

		User user = null;
		
		for (UserVO userVO: users) {
			user = userDao.save(UserConverter.toEntity(userVO));
			storedUsers.add(UserConverter.toVO(user));
			logger.debug(user.getId());
		}
		return users;
	}

	@Override
	public List<UserVO> updateUsers(List<UserVO> users) throws Exception {
		
		if (users == null || users.isEmpty()) {
			return Collections.emptyList();
		}
		
		List<UserVO> userVOs = new ArrayList<UserVO>();
		User user = null;
		
		for (UserVO userVO: users) {
			userDao.update(UserConverter.toEntity(userVO));
			user = userDao.find(userVO.getId());
			userVOs.add(UserConverter.toVO(user));
		}
		
		return userVOs;
	}

}
