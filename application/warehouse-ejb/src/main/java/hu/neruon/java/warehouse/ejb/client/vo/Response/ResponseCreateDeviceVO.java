package hu.neruon.java.warehouse.ejb.client.vo.Response;

import hu.neruon.java.warehouse.ejb.client.vo.DeviceBasedataVO;

import java.io.Serializable;
import java.util.List;

public class ResponseCreateDeviceVO extends ResponseBaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<DeviceBasedataVO> deviceBaseDatas;

	public List<DeviceBasedataVO> getDeviceBaseDatas() {
		return deviceBaseDatas;
	}

	public void setDeviceBaseDatas(List<DeviceBasedataVO> deviceBaseDatas) {
		this.deviceBaseDatas = deviceBaseDatas;
	}
}
