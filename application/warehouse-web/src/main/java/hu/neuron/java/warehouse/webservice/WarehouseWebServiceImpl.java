package hu.neuron.java.warehouse.webservice;

import javax.jws.WebService;

@WebService(
		targetNamespace="http://localhost",
        portName = "WarehouseWebServicePort",
        serviceName = "WarehouseWebService",
        endpointInterface = "hu.neuron.java.warehouse.webservice.WarehouseWebService")
public class WarehouseWebServiceImpl implements WarehouseWebService{

	@Override
	public String getDate() {
		return "asdas";
	}

}
