package hu.neruon.java.warehouse.ejb.client.vo;

import java.io.Serializable;
import java.util.Collection;

public class WarehouseVO implements Serializable {

	private static final long serialVersionUID = -7733674037625889368L;
	
	private Long id;

	private String name;

	private String addressCountry;

	private String addressCity;

	private String addressPostcode;

	private String addressStreet;

	private String number;

	private Collection<UserVO> workers;

	private Collection<UserVO> managers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressPostcode() {
		return addressPostcode;
	}

	public void setAddressPostcode(String addressPostcode) {
		this.addressPostcode = addressPostcode;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Collection<UserVO> getWorkers() {
		return workers;
	}

	public void setWorkers(Collection<UserVO> workers) {
		this.workers = workers;
	}

	public Collection<UserVO> getManagers() {
		return managers;
	}

	public void setManagers(Collection<UserVO> managers) {
		this.managers = managers;
	}

}
