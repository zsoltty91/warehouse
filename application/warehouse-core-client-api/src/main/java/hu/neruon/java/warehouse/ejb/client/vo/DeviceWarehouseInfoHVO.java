package hu.neruon.java.warehouse.ejb.client.vo;

import java.io.Serializable;
import java.util.Date;

public class DeviceWarehouseInfoHVO implements Serializable{

	private static final long serialVersionUID = -229530835575918390L;
	
	private DeviceWarehouseInfoVO deviceWarehouseInfo;
	
	private UserVO user;
	
	private Date createDate;
	
	private Integer count;
	
	public DeviceWarehouseInfoHVO() {

	}

	public DeviceWarehouseInfoHVO(DeviceWarehouseInfoVO deviceWarehouseInfo,
			UserVO user, Date createDate, Integer count) {
		super();
		this.deviceWarehouseInfo = deviceWarehouseInfo;
		this.user = user;
		this.createDate = createDate;
		this.count = count;
	}

	public DeviceWarehouseInfoVO getDeviceWarehouseInfo() {
		return deviceWarehouseInfo;
	}

	public void setDeviceWarehouseInfo(DeviceWarehouseInfoVO deviceWarehouseInfo) {
		this.deviceWarehouseInfo = deviceWarehouseInfo;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
