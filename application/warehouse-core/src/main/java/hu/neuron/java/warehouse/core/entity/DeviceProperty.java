package hu.neuron.java.warehouse.core.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "device_property")
public class DeviceProperty extends BaseEntity {

	private static final long serialVersionUID = -2948196286856535525L;

	String value;

	@ManyToOne
	@JoinColumn(name = "property_fk", nullable = false)
	Property property;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
}
