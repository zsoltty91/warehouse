package hu.neruon.java.warehouse.ejb;

import hu.neruon.java.warehouse.ejb.client.service.DeviceServiceFacadeBeanLocal;
import hu.neruon.java.warehouse.ejb.client.service.DeviceServiceFacadeBeanRemote;
import hu.neruon.java.warehouse.ejb.client.vo.DeviceBasedataVO;
import hu.neruon.java.warehouse.ejb.client.vo.PropertyVO;
import hu.neruon.java.warehouse.ejb.converter.DeviceBaseDataConverter;
import hu.neruon.java.warehouse.ejb.converter.PropertyConverter;
import hu.neuron.java.warehouse.core.dao.DeviceBasedataDao;
import hu.neuron.java.warehouse.core.dao.DevicePropertyDao;
import hu.neuron.java.warehouse.core.dao.PropertyDao;
import hu.neuron.java.warehouse.core.entity.DeviceBasedata;
import hu.neuron.java.warehouse.core.entity.Property;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@Stateless(mappedName = "DeviceServiceFacadeBean")
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DeviceServiceFacadeBean implements DeviceServiceFacadeBeanLocal, DeviceServiceFacadeBeanRemote {

	private static final Logger logger = Logger.getLogger(DeviceServiceFacadeBean.class);

	@Autowired
	PropertyDao propertyDao;

	@Autowired
	DeviceBasedataDao deviceBasedataDao;

	@Autowired
	DevicePropertyDao devicePropertyDao;

	@Override
	public List<PropertyVO> findAllProperty() throws Exception {
		List<Property> properties = propertyDao.findAll();

		ArrayList<PropertyVO> propertyVOs = new ArrayList<PropertyVO>();
		PropertyVO propertyVO = null;

		for (Property property : properties) {
			propertyVO = new PropertyVO();

			propertyVO.setId(property.getId());
			propertyVO.setName(property.getName());

			propertyVOs.add(propertyVO);
		}
		return propertyVOs;
	}

	@Override
	public List<DeviceBasedataVO> findAllDeviceBaseData() throws Exception {
		List<DeviceBasedata> deviceBasedatas = deviceBasedataDao.findAll();

		return DeviceBaseDataConverter.toVO(deviceBasedatas);
	}

	@Override
	public List<DeviceBasedataVO> createDevices(List<DeviceBasedataVO> deviceBasedatas) throws Exception {

		List<DeviceBasedataVO> devices = new ArrayList<DeviceBasedataVO>();

		for (DeviceBasedataVO deviceBasedataVO : deviceBasedatas) {

			devices.add(DeviceBaseDataConverter.toVO(deviceBasedataDao.save(DeviceBaseDataConverter
					.toEntity(deviceBasedataVO))));
		}

		return deviceBasedatas;
	}

	@Override
	public List<PropertyVO> createProperties(List<PropertyVO> properties) throws Exception {

		for (PropertyVO propertyVO : properties) {
			Property property = propertyDao.save(PropertyConverter.toEntity(propertyVO));
			propertyVO.setId(property.getId());
		}

		return properties;
	}

}
