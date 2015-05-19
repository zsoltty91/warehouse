package hu.neruon.java.warehouse.ejb.client.vo;

import java.io.Serializable;


public class DeviceWarehouseInfoVO implements Serializable{

	private static final long serialVersionUID = -3995381601306519262L;
	
	private Long id;

	private DeviceBasedataVO deviceBasedata;
	
	private WarehouseVO warehouse;
	
	private Integer count;
	
	public DeviceWarehouseInfoVO() {
		super();
	}

	public DeviceBasedataVO getDeviceBasedata() {
		return deviceBasedata;
	}

	public void setDeviceBasedata(DeviceBasedataVO deviceBasedata) {
		this.deviceBasedata = deviceBasedata;
	}

	public WarehouseVO getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(WarehouseVO warehouse) {
		this.warehouse = warehouse;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
