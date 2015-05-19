package hu.neruon.java.warehouse.ejb.client.vo.request;

import hu.neruon.java.warehouse.ejb.client.vo.DeviceBasedataVO;

import java.io.Serializable;
import java.util.List;

public class RequestCreateDeviceVO extends RequestBaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<DeviceBasedataVO> deviceBasedatas;

	public List<DeviceBasedataVO> getDeviceBasedatas() {
		return deviceBasedatas;
	}

	public void setDeviceBasedatas(List<DeviceBasedataVO> deviceBasedatas) {
		this.deviceBasedatas = deviceBasedatas;
	}
}
