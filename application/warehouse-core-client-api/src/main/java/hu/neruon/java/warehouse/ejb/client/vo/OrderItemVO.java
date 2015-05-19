package hu.neruon.java.warehouse.ejb.client.vo;

import java.io.Serializable;

public class OrderItemVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Integer count;

	private DeviceBasedataVO deviceBasedata;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public DeviceBasedataVO getDeviceBasedata() {
		return deviceBasedata;
	}

	public void setDeviceBasedata(DeviceBasedataVO deviceBasedata) {
		this.deviceBasedata = deviceBasedata;
	}

	public OrderItemVO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderItemVO(Long id, Integer count, DeviceBasedataVO deviceBasedata) {
		super();
		this.id = id;
		this.count = count;
		this.deviceBasedata = deviceBasedata;
	}
}
