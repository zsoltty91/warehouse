package hu.neuron.java.warehouse.common.dto;

import java.io.Serializable;

public class PropertyDTO implements Serializable {

	private static final long serialVersionUID = -7943028132664775524L;

	private Long id;
	private String name;

	public PropertyDTO() {
		super();
	}

	public PropertyDTO(String name, Long id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
