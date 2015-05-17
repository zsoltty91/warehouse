package hu.neuron.java.warehouse.common.dto;

import java.io.Serializable;
import java.util.Collection;

public class DeviceBaseDataDTO implements Serializable {

	private static final long serialVersionUID = 8484604788123325359L;

	private Long id;

	private String manufacturer;

	private String type;

	private String description;

	private Boolean visible;

	private Collection<DevicePropertyDTO> properties;

	public DeviceBaseDataDTO() {
		super();
	}

	public DeviceBaseDataDTO(Long id, String manufacturer, String type, String description, Boolean visible,
			Collection<DevicePropertyDTO> properties) {
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

	public Collection<DevicePropertyDTO> getProperties() {
		return properties;
	}

	public void setProperties(Collection<DevicePropertyDTO> properties) {
		this.properties = properties;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
