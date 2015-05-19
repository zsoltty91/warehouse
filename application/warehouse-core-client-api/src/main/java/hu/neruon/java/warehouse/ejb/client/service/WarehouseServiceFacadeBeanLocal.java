package hu.neruon.java.warehouse.ejb.client.service;

import hu.neruon.java.warehouse.ejb.client.vo.DeviceBasedataVO;
import hu.neruon.java.warehouse.ejb.client.vo.PropertyVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface WarehouseServiceFacadeBeanLocal {

	public List<PropertyVO> findAllProperty() throws Exception;

	public List<DeviceBasedataVO> findAllDeviceBaseData() throws Exception;

	public List<DeviceBasedataVO> createDevices(List<DeviceBasedataVO> deviceBasedatas) throws Exception;

	public List<PropertyVO> createProperties(List<PropertyVO> properties) throws Exception;
}
