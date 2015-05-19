package hu.neuron.java.warehouse.core.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItem extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer count;

	@ManyToOne
	@JoinColumn(name = "device_basedata_fk")
	private DeviceBasedata deviceBasedata;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public DeviceBasedata getDeviceBasedata() {
		return deviceBasedata;
	}

	public void setDeviceBasedata(DeviceBasedata deviceBasedata) {
		this.deviceBasedata = deviceBasedata;
	}
}
