package hu.neuron.java.warehouse.web.controller;

import hu.neruon.java.warehouse.ejb.client.service.DeviceServiceFacadeBeanLocal;
import hu.neruon.java.warehouse.ejb.client.vo.DeviceBasedataVO;
import hu.neruon.java.warehouse.ejb.client.vo.DevicePropertyVO;
import hu.neruon.java.warehouse.ejb.client.vo.PropertyVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;

@SessionScoped
@ManagedBean(name = "deviceController")
public class DeviceController {

	private static final Logger logger = Logger.getLogger(DeviceController.class);

	@EJB
	DeviceServiceFacadeBeanLocal propertyService;

	private List<PropertyVO> deviceProperties;

	private List<DeviceBasedataVO> deviceBasedatas;

	private DeviceBasedataVO selectedDevice;

	private DeviceBasedataVO createDevice;

	private DevicePropertyVO createDeviceProperty;

	@PostConstruct
	public void init() {
		try {
			deviceProperties = propertyService.findAllProperty();
			deviceBasedatas = propertyService.findAllDeviceBaseData();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		this.createDevice = new DeviceBasedataVO();
		this.createDeviceProperty = new DevicePropertyVO();
		createDeviceProperty.setProperty(deviceProperties.get(0));
	}

	public void onSelect(SelectEvent event) {
		System.out.println("selected" + this.selectedDevice);
	}

	public void addDeviceProperty() {
		if (this.createDeviceProperty != null && this.createDeviceProperty.getValue() != null
				&& !this.createDeviceProperty.getValue().isEmpty()
				&& this.createDeviceProperty.getProperty().getId() != null) {
			List<DevicePropertyVO> properties = this.createDevice.getProperties();
			if (properties == null) {
				properties = new ArrayList<DevicePropertyVO>();
				this.createDevice.setProperties(properties);
			}
			properties.add(createDeviceProperty);
			createDeviceProperty = new DevicePropertyVO();
		}
	}

	public boolean ishasSelectedDevice() {
		return this.selectedDevice != null;
	}

	public List<PropertyVO> getDeviceProperties() {
		return deviceProperties;
	}

	public void setDeviceProperties(List<PropertyVO> deviceProperties) {
		this.deviceProperties = deviceProperties;
	}

	public List<DeviceBasedataVO> getDeviceBasedatas() {
		return deviceBasedatas;
	}

	public void setDeviceBasedatas(List<DeviceBasedataVO> deviceBasedatas) {
		this.deviceBasedatas = deviceBasedatas;
	}

	public DeviceBasedataVO getSelectedDevice() {
		return selectedDevice;
	}

	public void setSelectedDevice(DeviceBasedataVO selectedDevice) {
		this.selectedDevice = selectedDevice;
	}

	public DeviceBasedataVO getCreateDevice() {
		return createDevice;
	}

	public void setCreateDevice(DeviceBasedataVO createDevice) {
		this.createDevice = createDevice;
	}

	public DevicePropertyVO getCreateDeviceProperty() {
		return createDeviceProperty;
	}

	public void setCreateDeviceProperty(DevicePropertyVO createDeviceProperty) {
		this.createDeviceProperty = createDeviceProperty;
	}
}
