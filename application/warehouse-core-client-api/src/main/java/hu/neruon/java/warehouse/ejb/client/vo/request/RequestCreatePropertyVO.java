package hu.neruon.java.warehouse.ejb.client.vo.request;

import hu.neruon.java.warehouse.ejb.client.vo.PropertyVO;

import java.io.Serializable;
import java.util.List;

public class RequestCreatePropertyVO extends RequestBaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	List<PropertyVO> properties;

	public List<PropertyVO> getProperties() {
		return properties;
	}

	public void setProperties(List<PropertyVO> properties) {
		this.properties = properties;
	}
}
