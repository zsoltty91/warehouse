package hu.neruon.java.warehouse.ejb.client.service;

import hu.neruon.java.warehouse.ejb.client.vo.DeviceBasedataVO;
import hu.neruon.java.warehouse.ejb.client.vo.PropertyVO;
import hu.neruon.java.warehouse.ejb.client.vo.Response.ResponseCreateDeviceVO;
import hu.neruon.java.warehouse.ejb.client.vo.Response.ResponseCreatePropertyVO;
import hu.neruon.java.warehouse.ejb.client.vo.request.RequestCreateDeviceVO;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface DeviceServiceFacadeBeanRemote {
	
	public List<PropertyVO> findAllProperty() throws Exception;
	
	public List<DeviceBasedataVO> findAllDeviceBaseData() throws Exception;
	
	public ResponseCreateDeviceVO createDevices(RequestCreateDeviceVO request) throws Exception;
	
	public ResponseCreatePropertyVO createProperties(ResponseCreatePropertyVO request) throws Exception;
}
