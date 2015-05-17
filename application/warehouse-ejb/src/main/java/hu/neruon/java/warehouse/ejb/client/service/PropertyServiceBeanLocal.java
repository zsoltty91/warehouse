package hu.neruon.java.warehouse.ejb.client.service;

import hu.neruon.java.warehouse.ejb.client.vo.PropertyVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface PropertyServiceBeanLocal {
	
	public List<PropertyVO> findAllProperty() throws Exception;
	
}
