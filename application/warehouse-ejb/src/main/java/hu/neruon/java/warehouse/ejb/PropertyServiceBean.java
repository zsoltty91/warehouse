package hu.neruon.java.warehouse.ejb;

import java.util.ArrayList;
import java.util.List;

import hu.neruon.java.warehouse.ejb.client.service.PropertyServiceBeanLocal;
import hu.neruon.java.warehouse.ejb.client.service.PropertyServiceBeanRemote;
import hu.neruon.java.warehouse.ejb.client.vo.PropertyVO;
import hu.neuron.java.warehouse.common.dao.PropertyDao;
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
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PropertyServiceBean implements PropertyServiceBeanLocal, PropertyServiceBeanRemote {

	private static final Logger logger = Logger.getLogger(PropertyServiceBean.class);
	
	@Autowired
	PropertyDao propertyDao;

	@Override
	public List<PropertyVO> findAllProperty() throws Exception {
		logger.error("find eleje\n\n\n\n\n\n\n");
		List<PropertyDTO> properties = propertyDao.findAll();

		ArrayList<PropertyVO> propertyVOs = new ArrayList<PropertyVO>();
		PropertyVO propertyVO = null;

		for (PropertyDTO property : properties) {
			propertyVO = new PropertyVO();

			propertyVO.setId(property.getId());
			propertyVO.setName(property.getName());

			propertyVOs.add(propertyVO);
		}
		logger.error("find vege\n\n\n\n\n\n\n");
		return propertyVOs;
	}

}
