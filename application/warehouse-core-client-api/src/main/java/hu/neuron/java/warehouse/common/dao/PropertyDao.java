package hu.neuron.java.warehouse.common.dao;

import hu.neuron.java.warehouse.common.dto.PropertyDTO;

public interface PropertyDao extends BaseDAO<PropertyDTO> {
	
	PropertyDTO findPropertyByName(String name) throws Exception;
	
}
