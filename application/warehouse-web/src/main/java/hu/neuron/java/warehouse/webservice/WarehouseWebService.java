package hu.neuron.java.warehouse.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace="http://localhost")
public interface WarehouseWebService {
	
	@WebMethod
	public String getDate();
	
}
