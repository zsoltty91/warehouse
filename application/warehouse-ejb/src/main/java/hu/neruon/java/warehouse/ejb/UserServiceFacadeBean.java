package hu.neruon.java.warehouse.ejb;

import java.util.List;

import hu.neruon.java.warehouse.ejb.client.service.UserServiceFacadeBeanLocal;
import hu.neruon.java.warehouse.ejb.client.service.UserServiceFacadeBeanRemote;
import hu.neruon.java.warehouse.ejb.client.vo.UserVO;

public class UserServiceFacadeBean implements UserServiceFacadeBeanLocal, UserServiceFacadeBeanRemote{

	@Override
	public List<UserVO> findAllUser() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO createUsers(List<UserVO> users) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO updateUsers(List<UserVO> users) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
