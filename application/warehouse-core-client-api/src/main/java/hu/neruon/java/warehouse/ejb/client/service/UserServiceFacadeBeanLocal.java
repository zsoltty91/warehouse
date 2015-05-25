package hu.neruon.java.warehouse.ejb.client.service;

import hu.neruon.java.warehouse.ejb.client.vo.UserVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface UserServiceFacadeBeanLocal {
	
	public List<UserVO> findAllUser() throws Exception;
	
	public List<UserVO> createUsers(List<UserVO> users) throws Exception;
	
	public List<UserVO> updateUsers(List<UserVO> users) throws Exception;
	
}
