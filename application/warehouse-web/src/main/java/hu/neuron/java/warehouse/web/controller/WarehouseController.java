package hu.neuron.java.warehouse.web.controller;

import hu.neruon.java.warehouse.ejb.client.service.WarehouseServiceFacadeBeanLocal;
import hu.neruon.java.warehouse.ejb.client.vo.WarehouseVO;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "warehouseController")
public class WarehouseController implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	WarehouseServiceFacadeBeanLocal warehouseService;

	private List<WarehouseVO> warehouses;

	@PostConstruct
	public void init() {
		initWarehouses();
	}

	private void initWarehouses() {
		try {
			this.warehouses = warehouseService.findAllWarehouse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<WarehouseVO> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(List<WarehouseVO> warehouses) {
		this.warehouses = warehouses;
	}

}
