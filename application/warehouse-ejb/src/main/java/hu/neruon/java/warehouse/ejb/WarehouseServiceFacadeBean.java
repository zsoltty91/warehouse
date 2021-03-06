package hu.neruon.java.warehouse.ejb;

import hu.neruon.java.warehouse.ejb.client.service.WarehouseServiceFacadeBeanLocal;
import hu.neruon.java.warehouse.ejb.client.service.WarehouseServiceFacadeBeanRemote;
import hu.neruon.java.warehouse.ejb.client.vo.DeviceBasedataVO;
import hu.neruon.java.warehouse.ejb.client.vo.DeviceWarehouseInfoHVO;
import hu.neruon.java.warehouse.ejb.client.vo.DeviceWarehouseInfoVO;
import hu.neruon.java.warehouse.ejb.client.vo.OrderVO;
import hu.neruon.java.warehouse.ejb.client.vo.WarehouseVO;
import hu.neruon.java.warehouse.ejb.converter.DeviceBaseDataConverter;
import hu.neruon.java.warehouse.ejb.converter.DeviceWarehouseInfoConverter;
import hu.neruon.java.warehouse.ejb.converter.DeviceWarehouseInfoHConverter;
import hu.neruon.java.warehouse.ejb.converter.OrderConverter;
import hu.neruon.java.warehouse.ejb.converter.WarehouseConverter;
import hu.neuron.java.warehouse.core.dao.DeviceBasedataDao;
import hu.neuron.java.warehouse.core.dao.DeviceWarehouseInfoDao;
import hu.neuron.java.warehouse.core.dao.DeviceWarehouseInfoHDao;
import hu.neuron.java.warehouse.core.dao.OrderDao;
import hu.neuron.java.warehouse.core.dao.WarehouseDao;
import hu.neuron.java.warehouse.core.entity.DeviceBasedata;
import hu.neuron.java.warehouse.core.entity.DeviceWarehouseInfo;
import hu.neuron.java.warehouse.core.entity.DeviceWarehouseInfoH;
import hu.neuron.java.warehouse.core.entity.Order;
import hu.neuron.java.warehouse.core.entity.Warehouse;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@Stateless(mappedName = "WarehouseServiceFacadeBean")
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class WarehouseServiceFacadeBean implements WarehouseServiceFacadeBeanLocal, WarehouseServiceFacadeBeanRemote {

	@Autowired
	WarehouseDao warehouseDao;

	@Autowired
	OrderDao orderDao;

	@Autowired
	DeviceBasedataDao deviceBasedataDao;
	
	@Autowired
	DeviceWarehouseInfoDao deviceWarehouseInfoDao;

	@Autowired
	DeviceWarehouseInfoHDao deviceWarehouseInfoHDao;
	
	@Override
	public List<WarehouseVO> findAllWarehouse() throws Exception {
		List<Warehouse> warehouses = warehouseDao.findAll();
		if (warehouses != null && !warehouses.isEmpty()) {
			return WarehouseConverter.toVO(warehouses);
		}
		return Collections.emptyList();
	}

	@Override
	public List<WarehouseVO> createWarehouses(List<WarehouseVO> warehouses) throws Exception {
		if (warehouses == null || warehouses.isEmpty()) {
			return Collections.emptyList();
		}

		Warehouse warehouse = null;
		for (WarehouseVO warehouseVO : warehouses) {
			warehouse = warehouseDao.save(WarehouseConverter.toEntity(warehouseVO));
			warehouseVO.setId(warehouse.getId());
		}

		return warehouses;
	}

	@Override
	public List<OrderVO> findOrdersByWarehouse(Long warehouseId) throws Exception {
		if (warehouseId == null) {
			return Collections.emptyList();
		}

		List<Order> orders = orderDao.findOrdersByWarehouse(warehouseId);
		if (orders != null && !orders.isEmpty()) {
			return OrderConverter.toVO(orders);
		}

		return Collections.emptyList();
	}

	@Override
	public List<OrderVO> createOrders(List<OrderVO> orders) throws Exception {
		if (orders == null || orders.isEmpty()) {
			return Collections.emptyList();
		}

		Order order = null;
		for (OrderVO orderVO : orders) {
			order = orderDao.save(OrderConverter.toEntity(orderVO));
			orderVO.setId(order.getId());
		}

		return orders;
	}

	@Override
	public OrderVO completeOrder(Long orderId) throws Exception {
		Order order = orderDao.find(orderId);

		if (order == null) {
			return null;
		}

		order.setCompleted(Boolean.TRUE);
		orderDao.update(order);

		return OrderConverter.toVO(order);
	}

	@Override
	public List<DeviceWarehouseInfoVO> findDeviceWarehouseInfos(Long warehouseId) throws Exception {
		if (warehouseId == null) {
			return Collections.emptyList();
		}

		List<DeviceWarehouseInfo> infos = deviceWarehouseInfoDao.findDeviceWarehouseInfosByWarehouse(warehouseId);
		if (infos != null && !infos.isEmpty()) {
			return DeviceWarehouseInfoConverter.toVO(infos);
		}

		return Collections.emptyList();
	}

	@Override
	public List<DeviceWarehouseInfoVO> createDeviceWarehouseInfos(List<DeviceWarehouseInfoVO> deviceWarehouseInfos)
			throws Exception {

		if (deviceWarehouseInfos == null || deviceWarehouseInfos.isEmpty()) {
			return Collections.emptyList();
		}

		DeviceWarehouseInfo info = null;
		for (DeviceWarehouseInfoVO infoVO : deviceWarehouseInfos) {
			info = deviceWarehouseInfoDao.save(DeviceWarehouseInfoConverter.toEntity(infoVO));
			infoVO.setId(info.getId());
		}

		return deviceWarehouseInfos;
	}

	@Override
	public List<DeviceBasedataVO> findAllDeviceBasedata() throws Exception {
		List<DeviceBasedata> deviceBasedatas = deviceBasedataDao.findAll();

		return DeviceBaseDataConverter.toVO(deviceBasedatas);
	}

	@Override
	public List<DeviceWarehouseInfoHVO> findDeviceWarehouseInfoHs(
			Long warehouseId) throws Exception {
		List<DeviceWarehouseInfoHVO> ret = DeviceWarehouseInfoHConverter.toVO(deviceWarehouseInfoHDao.findDeviceWarehouseInfoHsByWarehouse(warehouseId));
		return ret;
	}

	@Override
	public List<DeviceWarehouseInfoHVO> createDeviceWarehouseInfoHs(
			List<DeviceWarehouseInfoHVO> deviceWarehouseInfoHs) throws Exception {

		if (deviceWarehouseInfoHs == null || deviceWarehouseInfoHs.isEmpty()) {
			return Collections.emptyList();
		}

		DeviceWarehouseInfoH infoH = null;
		for (DeviceWarehouseInfoHVO infoHVO : deviceWarehouseInfoHs) {
			infoH = deviceWarehouseInfoHDao.save(DeviceWarehouseInfoHConverter.toEntity(infoHVO));
			infoHVO.setId(infoH.getId());
			
			DeviceWarehouseInfo info = deviceWarehouseInfoDao.find(infoH.getDeviceWarehouseInfo().getId());
			
			info.setCount(info.getCount()+infoH.getCount());
			deviceWarehouseInfoDao.update(info);
		}

		return deviceWarehouseInfoHs;
		
	}

}
