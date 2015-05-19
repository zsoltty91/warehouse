package hu.neruon.java.warehouse.ejb.client.vo;

import java.io.Serializable;

public class PropertyVO implements Serializable {

	private static final long serialVersionUID = -7943028132664775524L;

	private Long id;
	private String name;

	public PropertyVO() {
		super();
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
