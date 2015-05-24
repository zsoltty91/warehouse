package hu.neruon.java.warehouse.ejb.client.vo;

import java.io.Serializable;
import java.util.List;

public class DeviceBasedataVO implements Serializable {

	private static final long serialVersionUID = 8484604788123325359L;

	private Long id;

	private String manufacturer;

	private String type;

	private String description;

	private Boolean visible;

	private List<DevicePropertyVO> properties;

	public DeviceBasedataVO() {
		super();
	}

	public DeviceBasedataVO(Long id, String manufacturer, String type, String description, Boolean visible,
			List<DevicePropertyVO> properties) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.type = type;
		this.description = description;
		this.visible = visible;
		this.properties = properties;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public List<DevicePropertyVO> getProperties() {
		return properties;
	}

	public void setProperties(List<DevicePropertyVO> properties) {
		this.properties = properties;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeviceBasedataVO other = (DeviceBasedataVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
