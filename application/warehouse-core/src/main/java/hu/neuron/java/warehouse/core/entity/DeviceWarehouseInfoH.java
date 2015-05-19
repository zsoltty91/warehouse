package hu.neuron.java.warehouse.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "device_warehouse_info_h")
public class DeviceWarehouseInfoH extends BaseEntity{

	private static final long serialVersionUID = -6951530757192607319L;
	
	@ManyToOne
	@JoinColumn(name = "device_warehouse_info_fk")
	private DeviceWarehouseInfo deviceWarehouseInfo;
	
	@ManyToOne
	@JoinColumn(name = "user_fk")
	private User user;
	
	@Column(name = "create_date")
	private Date createDate;
	
	private Integer count;
	
	public DeviceWarehouseInfoH() {

	}

	public DeviceWarehouseInfo getDeviceWarehouseInfo() {
		return deviceWarehouseInfo;
	}

	public void setDeviceWarehouseInfo(DeviceWarehouseInfo deviceWarehouseInfo) {
		this.deviceWarehouseInfo = deviceWarehouseInfo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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
