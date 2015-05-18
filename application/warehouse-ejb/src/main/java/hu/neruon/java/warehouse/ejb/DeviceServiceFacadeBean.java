package hu.neruon.java.warehouse.ejb;

import java.util.ArrayList;
import java.util.List;

import hu.neruon.java.warehouse.ejb.client.service.DeviceServiceFacadeBeanLocal;
import hu.neruon.java.warehouse.ejb.client.service.DeviceServiceFacadeBeanRemote;
import hu.neruon.java.warehouse.ejb.client.vo.DeviceBasedataVO;
import hu.neruon.java.warehouse.ejb.client.vo.DevicePropertyVO;
import hu.neruon.java.warehouse.ejb.client.vo.PropertyVO;
import hu.neruon.java.warehouse.ejb.client.vo.Response.ResponseCreateDeviceVO;
import hu.neruon.java.warehouse.ejb.client.vo.Response.ResponseCreatePropertyVO;
import hu.neruon.java.warehouse.ejb.client.vo.request.RequestCreateDeviceVO;
import hu.neruon.java.warehouse.ejb.converter.DeviceBaseDataConverter;
import hu.neruon.java.warehouse.ejb.converter.DevicePropertyConverter;
import hu.neruon.java.warehouse.ejb.converter.PropertyConverter;
import hu.neuron.java.warehouse.common.dao.DeviceBasedataDao;
import hu.neuron.java.warehouse.common.dao.DevicePropertyDao;
import hu.neuron.java.warehouse.common.dao.PropertyDao;
import hu.neuron.java.warehouse.common.dto.DeviceBaseDataDTO;
import hu.neuron.java.warehouse.common.dto.DevicePropertyDTO;
import hu.neuron.java.warehouse.common.dto.PropertyDTO;

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
		List<PropertyDTO> properties = propertyDao.findAll();

		ArrayList<PropertyVO> propertyVOs = new ArrayList<PropertyVO>();
		PropertyVO propertyVO = null;

		for (PropertyDTO property : properties) {
			propertyVO = new PropertyVO();

			propertyVO.setId(property.getId());
			propertyVO.setName(property.getName());

			propertyVOs.add(propertyVO);
		}
		return propertyVOs;
	}

	@Override
	public List<DeviceBasedataVO> findAllDeviceBaseData() throws Exception {
		List<DeviceBaseDataDTO> deviceBasedatas = deviceBasedataDao.findAll();

		return DeviceBaseDataConverter.toVO(deviceBasedatas);
	}

	@Override
	public ResponseCreateDeviceVO createDevices(RequestCreateDeviceVO request) throws Exception {

		ResponseCreateDeviceVO response = new ResponseCreateDeviceVO();

		if (request == null || request.getDeviceBasedatas() == null || request.getDeviceBasedatas().isEmpty()) {
			return response;
		}

		Long id;
		for (DeviceBasedataVO deviceBasedataVO : request.getDeviceBasedatas()) {
			PropertyDTO prop = new PropertyDTO();
			prop.setName("alma");
			prop.setId(4L);

			DevicePropertyDTO dto = new DevicePropertyDTO();
			dto.setProperty(prop);
			dto.setValue("value");

			DeviceBaseDataDTO basedto = new DeviceBaseDataDTO();
			basedto.setDescription("sdfsfd");
			basedto.setManufacturer("sdfsf");
			basedto.setType("ssfd");
			basedto.setVisible(Boolean.TRUE);
			basedto.setProperties(new ArrayList<DevicePropertyDTO>());
			basedto.getProperties().add(dto);

			id = deviceBasedataDao.save(basedto);
			System.out.println(id);
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
	public ResponseCreatePropertyVO createProperties(ResponseCreatePropertyVO request) throws Exception {
		ResponseCreatePropertyVO response = new ResponseCreatePropertyVO();

		if (request == null || request.getProperties() == null || request.getProperties().isEmpty()) {
			return response;
		}

		Long id;
		for (PropertyVO propertyVO : request.getProperties()) {
			id = propertyDao.save(PropertyConverter.toDTO(propertyVO));
			propertyVO.setId(id);
		}

		response.setProperties(request.getProperties());
		return response;
	}

}
