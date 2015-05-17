package hu.neuron.java.warehouse.core.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "device_basedata")
public class DeviceBasedata extends BaseEntity {

	private static final long serialVersionUID = 1674550505239436878L;

	private String manufacturer;

	private String type;

	private String description;

	private Boolean visible;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_base_fk")
	private Collection<DeviceProperty> properties;

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

	public Collection<DeviceProperty> getProperties() {
		return properties;
	}

	public void setProperties(Collection<DeviceProperty> properties) {
		this.properties = properties;
	}
}
