package hu.neuron.java.warehouse.web.controller;

import hu.neruon.java.warehouse.ejb.client.service.DeviceServiceFacadeBeanLocal;
import hu.neruon.java.warehouse.ejb.client.vo.DeviceBasedataVO;
import hu.neruon.java.warehouse.ejb.client.vo.DevicePropertyVO;
import hu.neruon.java.warehouse.ejb.client.vo.PropertyVO;
import hu.neruon.java.warehouse.ejb.client.vo.request.RequestCreateDeviceVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;

@SessionScoped
@ManagedBean(name = "deviceController")
public class DeviceController implements Serializable {

	private static final long serialVersionUID = -5568624268193063762L;

	private static final Logger logger = Logger.getLogger(DeviceController.class);

	@EJB
	DeviceServiceFacadeBeanLocal propertyService;

	private Map<Long, PropertyVO> deviceProperties;

	private List<DeviceBasedataVO> deviceBasedatas;

	private DeviceBasedataVO selectedDevice;

	private DeviceBasedataVO createDevice;

	private DevicePropertyVO createDeviceProperty;

	private PropertyVO createProperty;

	@PostConstruct
	public void init() {
		initProperties();
		initDeviceBasedatas();
		this.createDevice = new DeviceBasedataVO();
		this.createProperty = new PropertyVO();
		initCreateDeviceProperty();
	}

	private void initProperties() {
		this.deviceProperties = new HashMap<Long, PropertyVO>();
		try {
			List<PropertyVO> properties = propertyService.findAllProperty();
			for (PropertyVO property : properties) {
				this.deviceProperties.put(property.getId(), property);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private void initDeviceBasedatas() {
		try {
			deviceBasedatas = propertyService.findAllDeviceBaseData();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private void initCreateDeviceProperty() {
		this.createDeviceProperty = new DevicePropertyVO();
		if(deviceProperties.values().size()!=0){
			PropertyVO prop = deviceProperties.values().toArray(new PropertyVO[deviceProperties.values().size()])[0];
			this.createDeviceProperty.setProperty(new PropertyVO());
			this.createDeviceProperty.getProperty().setId(prop.getId());
			this.createDeviceProperty.getProperty().setName(prop.getName());
		} else {
			this.createDeviceProperty.setProperty(new PropertyVO());
		}
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
			createDeviceProperty.getProperty().setName(
					this.deviceProperties.get(createDeviceProperty.getProperty().getId()).getName());
			properties.add(createDeviceProperty);
			initCreateDeviceProperty();
		}
	}

	public void createProperty() {
		System.out.println(this.createProperty);
		ArrayList<PropertyVO> properties = new ArrayList<PropertyVO>();
		properties.add(this.createProperty);
		try {
			propertyService.createProperties(properties);
			this.createProperty = new PropertyVO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		initProperties();
	}

	public void createDevice() {
		System.out.println(this.createDevice);
		ArrayList<DeviceBasedataVO> deviceBasedatas = new ArrayList<DeviceBasedataVO>();
		deviceBasedatas.add(createDevice);
		try {
			propertyService.createDevices(deviceBasedatas);
			this.createDevice = new DeviceBasedataVO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initDeviceBasedatas();
	}

	public boolean ishasSelectedDevice() {
		return this.selectedDevice != null;
	}

	public Collection<PropertyVO> getDeviceProperties() {
		return deviceProperties.values();
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

	public PropertyVO getCreateProperty() {
		return createProperty;
	}

	public void setCreateProperty(PropertyVO createProperty) {
		this.createProperty = createProperty;
	}
}
