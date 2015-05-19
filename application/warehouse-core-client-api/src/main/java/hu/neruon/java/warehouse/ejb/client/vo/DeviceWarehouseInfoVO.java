package hu.neruon.java.warehouse.ejb.client.vo;

import java.io.Serializable;

public class DeviceWarehouseInfoVO implements Serializable {

	private static final long serialVersionUID = 6903779150325185063L;

	private DeviceBasedataVO deviceBasedata;
	
	private WarehouseVO warehouse;
	
	private Integer count;
	
	public DeviceWarehouseInfoVO() {
		super();
	}

	public DeviceWarehouseInfoVO(DeviceBasedataVO deviceBasedata,
			WarehouseVO warehouse, Integer count) {
		super();
		this.deviceBasedata = deviceBasedata;
		this.warehouse = warehouse;
		this.count = count;
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
	
	
}
