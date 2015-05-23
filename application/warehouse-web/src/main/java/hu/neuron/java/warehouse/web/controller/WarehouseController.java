package hu.neuron.java.warehouse.web.controller;

import hu.neruon.java.warehouse.ejb.client.service.WarehouseServiceFacadeBeanLocal;
import hu.neruon.java.warehouse.ejb.client.vo.DeviceWarehouseInfoHVO;
import hu.neruon.java.warehouse.ejb.client.vo.DeviceWarehouseInfoVO;
import hu.neruon.java.warehouse.ejb.client.vo.OrderVO;
import hu.neruon.java.warehouse.ejb.client.vo.UserVO;
import hu.neruon.java.warehouse.ejb.client.vo.WarehouseVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

@ViewScoped
@ManagedBean(name = "warehouseController")
public class WarehouseController implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	WarehouseServiceFacadeBeanLocal warehouseService;

	private List<WarehouseVO> warehouses;
	private WarehouseVO newWarehouse;
	private WarehouseVO selectedWarehouse;
	private List<DeviceWarehouseInfoVO> selectedWarehouseInfos;
	private List<DeviceWarehouseInfoHVO> selectedWarehouseInfoHs;
	private List<OrderVO> selectedOrders;

	@PostConstruct
	public void init() {
		initWarehouses();
	}

	private void initWarehouses() {
		newWarehouse = new WarehouseVO();
		newWarehouse.setWorkers(new ArrayList<UserVO>());
		newWarehouse.setManagers(new ArrayList<UserVO>());
		try {
			this.warehouses = warehouseService.findAllWarehouse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addWarehouse(){
		List<WarehouseVO> warehouseVOs = new ArrayList<WarehouseVO>(1);
		warehouseVOs.add(newWarehouse);
		try {
			warehouseService.createWarehouses(warehouseVOs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		newWarehouse = new WarehouseVO();
		newWarehouse.setWorkers(new ArrayList<UserVO>());
		newWarehouse.setManagers(new ArrayList<UserVO>());
	}
	
	public void onSelect(SelectEvent event) {
		System.out.println("selected" + this.selectedWarehouse);
		try {
			selectedWarehouseInfos = warehouseService.findDeviceWarehouseInfos(selectedWarehouse.getId());
			//selectedWarehouseInfoHs = warehouseService.findDeviceWarehouseInfoHs(selectedWarehouse.getId());
			setSelectedOrders(warehouseService.findOrdersByWarehouse(selectedWarehouse.getId()));
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

	public WarehouseVO getNewWarehouse() {
		return newWarehouse;
	}

	public void setNewWarehouse(WarehouseVO newWarehouse) {
		this.newWarehouse = newWarehouse;
	}

	public WarehouseVO getSelectedWarehouse() {
		return selectedWarehouse;
	}

	public void setSelectedWarehouse(WarehouseVO selectedWarehouse) {
		this.selectedWarehouse = selectedWarehouse;
	}

	public List<DeviceWarehouseInfoVO> getSelectedWarehouseInfos() {
		return selectedWarehouseInfos;
	}

	public void setSelectedWarehouseInfos(List<DeviceWarehouseInfoVO> selectedWarehouseInfos) {
		this.selectedWarehouseInfos = selectedWarehouseInfos;
	}

	public List<DeviceWarehouseInfoHVO> getSelectedWarehouseInfoHs() {
		return selectedWarehouseInfoHs;
	}

	public void setSelectedWarehouseInfoHs(List<DeviceWarehouseInfoHVO> selectedWarehouseInfoHs) {
		this.selectedWarehouseInfoHs = selectedWarehouseInfoHs;
	}

	public List<OrderVO> getSelectedOrders() {
		return selectedOrders;
	}

	public void setSelectedOrders(List<OrderVO> selectedOrders) {
		this.selectedOrders = selectedOrders;
	}



}
