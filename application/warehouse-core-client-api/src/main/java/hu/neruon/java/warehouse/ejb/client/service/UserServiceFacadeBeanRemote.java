package hu.neruon.java.warehouse.ejb.client.service;

import hu.neruon.java.warehouse.ejb.client.vo.UserVO;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface UserServiceFacadeBeanRemote {
	
	public List<UserVO> findAllUser() throws Exception;
	
	public UserVO createUsers(List<UserVO> users) throws Exception;
	
	public UserVO updateUsers(List<UserVO> users) throws Exception;
	
	
}
