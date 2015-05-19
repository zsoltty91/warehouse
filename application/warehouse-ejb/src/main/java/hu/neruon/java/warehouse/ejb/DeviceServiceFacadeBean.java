package hu.neruon.java.warehouse.ejb;

import hu.neruon.java.warehouse.ejb.client.service.DeviceServiceFacadeBeanLocal;
import hu.neruon.java.warehouse.ejb.client.service.DeviceServiceFacadeBeanRemote;
import hu.neruon.java.warehouse.ejb.client.vo.DeviceBasedataVO;
import hu.neruon.java.warehouse.ejb.client.vo.PropertyVO;
import hu.neruon.java.warehouse.ejb.client.vo.Response.ResponseCreateDeviceVO;
import hu.neruon.java.warehouse.ejb.client.vo.Response.ResponseCreatePropertyVO;
import hu.neruon.java.warehouse.ejb.client.vo.request.RequestCreateDeviceVO;
import hu.neruon.java.warehouse.ejb.converter.DeviceBaseDataConverter;
import hu.neruon.java.warehouse.ejb.converter.PropertyConverter;
import hu.neuron.java.warehouse.core.dao.DeviceBasedataDao;
import hu.neuron.java.warehouse.core.dao.DevicePropertyDao;
import hu.neuron.java.warehouse.core.dao.PropertyDao;
import hu.neuron.java.warehouse.core.entity.DeviceBasedata;
import hu.neuron.java.warehouse.core.entity.DeviceProperty;
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

@Stateless(mappedName = "PropertyServiceBean")
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DeviceServiceFacadeBean implements DeviceServiceFacadeBeanLocal,
		DeviceServiceFacadeBeanRemote {

	private static final Logger logger = Logger
			.getLogger(DeviceServiceFacadeBean.class);

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
	public ResponseCreateDeviceVO createDevices(RequestCreateDeviceVO request)
			throws Exception {

		ResponseCreateDeviceVO response = new ResponseCreateDeviceVO();

		if (request == null || request.getDeviceBasedatas() == null
				|| request.getDeviceBasedatas().isEmpty()) {
			return response;
		}

		Long id;
		for (DeviceBasedataVO deviceBasedataVO : request.getDeviceBasedatas()) {
			Property prop = new Property();
			prop.setName("alma");
			prop.setId(4L);

			DeviceProperty dto = new DeviceProperty();
			dto.setProperty(prop);
			dto.setValue("value");

			DeviceBasedata basedto = new DeviceBasedata();
			basedto.setDescription("sdfsfd");
			basedto.setManufacturer("sdfsf");
			basedto.setType("ssfd");
			basedto.setVisible(Boolean.TRUE);
			basedto.setProperties(new ArrayList<DeviceProperty>());
			basedto.getProperties().add(dto);

			basedto = deviceBasedataDao.save(basedto);
			System.out.println(basedto);
			// DevicePropertyVO property =
			// deviceBasedataVO.getProperties().get(0);
			// DevicePropertyDTO dto = DevicePropertyConverter.toDTO(property);
			// id = devicePropertyDao.save(dto);
			// System.out.println(id);
			// id =
			// deviceBasedataDao.save(DeviceBaseDataConverter.toDTO(deviceBasedataVO));
			// deviceBasedataVO.setId(id);
		}

		response.setDeviceBaseDatas(request.getDeviceBasedatas());
		return response;
	}

	@Override
	public ResponseCreatePropertyVO createProperties(
			ResponseCreatePropertyVO request) throws Exception {
		ResponseCreatePropertyVO response = new ResponseCreatePropertyVO();

		if (request == null || request.getProperties() == null
				|| request.getProperties().isEmpty()) {
			return response;
		}

		Long id;
		for (PropertyVO propertyVO : request.getProperties()) {
			Property property = propertyDao.save(PropertyConverter
					.toDTO(propertyVO));
			propertyVO.setId(property.getId());
		}

		response.setProperties(request.getProperties());
		return response;
	}

}
