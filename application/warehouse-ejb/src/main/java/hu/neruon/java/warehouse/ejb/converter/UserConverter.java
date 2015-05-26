package hu.neruon.java.warehouse.ejb.converter;

import hu.neruon.java.warehouse.ejb.client.vo.UserVO;
import hu.neuron.java.warehouse.core.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserConverter {
	public static User toEntity(UserVO vo) {
		User entity = new User();
		
		if(vo != null){
			entity.setAddress(vo.getAddress());
			entity.setBirthday(vo.getBirthday());
			entity.setId(vo.getId());
			entity.setPassword(vo.getPassword());
			entity.setLoginName(vo.getLoginName());
			entity.setName(vo.getName());
			entity.setRole(vo.getRole());
		}
		
		return entity;
	}

	public static Collection<User> toEntity(Collection<UserVO> vos) {
		List<User> entities = new ArrayList<User>();

		for (UserVO vo : vos) {
			entities.add(toEntity(vo));
		}

		return entities;
	}

	public static UserVO toVO(User entity) {
		UserVO vo = new UserVO();

		vo.setAddress(entity.getAddress());
		vo.setBirthday(entity.getBirthday());
		vo.setId(entity.getId());
		vo.setPassword(entity.getPassword());
		vo.setLoginName(entity.getLoginName());
		vo.setName(entity.getLoginName());
		vo.setRole(entity.getRole());

		return vo;
	}

	public static List<UserVO> toVO(Collection<User> entities) {
		List<UserVO> vos = new ArrayList<UserVO>();

		for (User entity : entities) {
			vos.add(toVO(entity));
		}

		return vos;
	}
}
