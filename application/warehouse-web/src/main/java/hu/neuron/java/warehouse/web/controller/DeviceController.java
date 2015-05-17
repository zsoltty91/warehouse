package hu.neuron.java.warehouse.web.controller;

import hu.neruon.java.warehouse.ejb.client.service.DeviceServiceFacadeBeanLocal;
import hu.neruon.java.warehouse.ejb.client.vo.DeviceBasedataVO;
import hu.neruon.java.warehouse.ejb.client.vo.PropertyVO;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;

@ViewScoped
@ManagedBean(name = "deviceController")
public class DeviceController {

	private static final Logger logger = Logger.getLogger(DeviceController.class);

	@EJB
	DeviceServiceFacadeBeanLocal propertyService;

	private List<PropertyVO> properties;
	
	private List<DeviceBasedataVO> deviceBasedatas;
	
	private DeviceBasedataVO selectedDevice;

	@PostConstruct
	public void init() {
		logger.error("hello\n\n\n\n\n\n\n");
		try {
			properties = propertyService.findAllProperty();
			deviceBasedatas = propertyService.findAllDeviceBaseData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.error(properties);
		logger.error("vege\n\n\n\n\n\n\n");
	}
	
	public void onSelect(SelectEvent event) {
    }

	public List<PropertyVO> getProperties() {
		return properties;
	}

	public void setProperties(List<PropertyVO> properties) {
		this.properties = properties;
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
}
