package hu.neuron.java.warehouse.web.controller;

import hu.neruon.java.warehouse.ejb.client.service.UserServiceFacadeBeanLocal;
import hu.neruon.java.warehouse.ejb.client.vo.UserVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

@ManagedBean(name = "userController")
@ViewScoped
public class UserController implements Serializable {

	private static final long serialVersionUID = -7250018145700421379L;

	private static Logger logger = Logger.getLogger(UserController.class);

	@EJB
	UserServiceFacadeBeanLocal userService;

	private List<UserVO> users;

	private UserVO userToCreate;

	@PostConstruct
	public void init() {
		userToCreate = new UserVO();
		initUsers();
	}

	private void initUsers() {
		try {
			this.users = userService.findAllUser();
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public void createUser() {
		try {
			List<UserVO> usersToCreate = new ArrayList<UserVO>();
			usersToCreate.add(userToCreate);
			userToCreate = new UserVO();
			List<UserVO> createdUsers = userService.createUsers(usersToCreate);
			users.addAll(createdUsers);
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	public void clearFields() {
		userToCreate = new UserVO();
		System.out.println(userToCreate.toString());
	}

	public List<UserVO> getUsers() {
		return users;
	}

	public void setUsers(List<UserVO> users) {
		this.users = users;
	}

	public UserVO getUserToCreate() {
		return userToCreate;
	}

	public void setUserToCreate(UserVO userToCreate) {
		this.userToCreate = userToCreate;
	}
}
