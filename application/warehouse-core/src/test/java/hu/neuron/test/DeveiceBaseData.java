package hu.neuron.test;

import hu.neuron.java.warehouse.core.dao.DeviceBasedataDao;
import hu.neuron.java.warehouse.core.dao.PropertyDao;
import hu.neuron.java.warehouse.core.entity.DeviceBasedata;
import hu.neuron.java.warehouse.core.entity.DeviceProperty;
import hu.neuron.java.warehouse.core.entity.Property;

import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test-core.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class DeveiceBaseData {

	@Autowired
	DeviceBasedataDao deviceBasedataDao;

	@Autowired
	PropertyDao propertyDao;

	@Test
	public void test() {

		Property prop = new Property();
		prop.setName("alma");

		try {
			prop = propertyDao.save(prop);
			System.out.println("save:" + prop);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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

		DeviceBasedata id;
		try {
			id = deviceBasedataDao.save(basedto);
			System.out.println(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// DevicePropertyVO property =
		// deviceBasedataVO.getProperties().get(0);
		// DevicePropertyDTO dto = DevicePropertyConverter.toDTO(property);
		// id = devicePropertyDao.save(dto);
		// System.out.println(id);
		// id =
		// deviceBasedataDao.save(DeviceBaseDataConverter.toDTO(deviceBasedataVO));
		// deviceBasedataVO.setId(id);

	}

}
