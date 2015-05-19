package hu.neuron.java.warehouse.core.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "device_warehouse_info")
public class DeviceWarehouseInfo extends BaseEntity{

	private static final long serialVersionUID = -3995381601306519262L;
	
	@ManyToOne
	@JoinColumn(name = "device_basedata_fk")
	private DeviceBasedata deviceBasedata;
	
	@ManyToOne
	@JoinColumn(name = "warehouse_fk")
	private Warehouse warehouse;
	
	private Integer count;
	
	public DeviceWarehouseInfo() {
		super();
	}

	public DeviceBasedata getDeviceBasedata() {
		return deviceBasedata;
	}

	public void setDeviceBasedata(DeviceBasedata deviceBasedata) {
		this.deviceBasedata = deviceBasedata;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
