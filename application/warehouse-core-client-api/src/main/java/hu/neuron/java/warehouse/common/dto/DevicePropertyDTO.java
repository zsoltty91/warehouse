package hu.neuron.java.warehouse.common.dto;

import java.io.Serializable;

public class DevicePropertyDTO implements Serializable {

	private static final long serialVersionUID = -7943028132664775524L;

	private Long id;
	private String value;
	private PropertyDTO property;

	public DevicePropertyDTO() {
		super();
	}

	public DevicePropertyDTO(String value, Long id) {
		super();
		this.value = value;
		this.id = id;
	}

	public DevicePropertyDTO(Long id, String value, PropertyDTO property) {
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

	public PropertyDTO getProperty() {
		return property;
	}

	public void setProperty(PropertyDTO property) {
		this.property = property;
	}
}
