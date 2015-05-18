package hu.neruon.java.warehouse.ejb.client.vo.Response;

import hu.neruon.java.warehouse.ejb.client.vo.PropertyVO;

import java.io.Serializable;
import java.util.List;

public class ResponseCreatePropertyVO extends ResponseBaseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	List<PropertyVO> properties;

	public List<PropertyVO> getProperties() {
		return properties;
	}

	public void setProperties(List<PropertyVO> properties) {
		this.properties = properties;
	}
}
