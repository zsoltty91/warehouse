package hu.neruon.java.warehouse.ejb.client.service;

import hu.neruon.java.warehouse.ejb.client.vo.PropertyVO;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface PropertyServiceBeanRemote {
	
	public List<PropertyVO> findAllProperty() throws Exception;
	
}
