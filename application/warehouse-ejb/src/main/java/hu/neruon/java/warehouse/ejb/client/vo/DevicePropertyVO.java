package hu.neruon.java.warehouse.ejb.client.vo;

import java.io.Serializable;

public class DevicePropertyVO implements Serializable {

	private static final long serialVersionUID = -7943028132664775524L;

	private Long id;
	private String value;
	private PropertyVO property;

	public DevicePropertyVO() {
		super();
	}

	public DevicePropertyVO(String value, Long id) {
		super();
		this.value = value;
		this.id = id;
	}

	public DevicePropertyVO(Long id, String value, PropertyVO property) {
		super();
		this.id = id;
		this.value = value;
		this.property = property;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PropertyVO getProperty() {
		return property;
	}

	public void setProperty(PropertyVO property) {
		this.property = property;
	}
}
