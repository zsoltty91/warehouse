package hu.neuron.java.warehouse.core.dao;

import hu.neuron.java.warehouse.core.entity.Property;



public interface PropertyDao extends BaseDAO<Property> {
	
	Property findPropertyByName(String name) throws Exception;
	
}
