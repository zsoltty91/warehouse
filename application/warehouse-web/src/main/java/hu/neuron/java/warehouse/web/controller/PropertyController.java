package hu.neuron.java.warehouse.web.controller;

import hu.neruon.java.warehouse.ejb.client.service.PropertyServiceBeanLocal;
import hu.neruon.java.warehouse.ejb.client.vo.PropertyVO;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

@ViewScoped
@ManagedBean(name = "propertyController")
public class PropertyController {

	private static final Logger logger = Logger.getLogger(PropertyController.class);

	@EJB
	PropertyServiceBeanLocal propertyService;

	private List<PropertyVO> properties;

	@PostConstruct
	public void init() {
		logger.error("hello\n\n\n\n\n\n\n");
		try {
			properties = propertyService.findAllProperty();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.error(properties);
		logger.error("vege\n\n\n\n\n\n\n");
	}

	public List<PropertyVO> getProperties() {
		return properties;
	}

	public void setProperties(List<PropertyVO> properties) {
		this.properties = properties;
	}
}
