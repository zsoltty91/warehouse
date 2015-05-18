package hu.neuron.java.warehouse.common.dto;

import java.io.Serializable;
import java.util.Collection;

public class WarehouseDTO implements Serializable {

	private static final long serialVersionUID = 3456314364491107279L;
	
	private Long id;
	
	private String name;
	
	private String addressCountry;
	
	private String addressCity;
	
	private String addressPostcode;
	
	private String addressStreet;
	
	private String number;

	private Collection<UserDTO> workers;
	
	private Collection<UserDTO> managers;
	
	public WarehouseDTO() {
		super();
	}

	public WarehouseDTO(String name, String addressCountry, String addressCity,
			String addressPostcode, String addressStreet, String number,
			Collection<UserDTO> workers, Collection<UserDTO> managers) {
		super();
		this.name = name;
		this.addressCountry = addressCountry;
		this.addressCity = addressCity;
		this.addressPostcode = addressPostcode;
		this.addressStreet = addressStreet;
		this.number = number;
		this.workers = workers;
		this.managers = managers;
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

	public Collection<UserDTO> getWorkers() {
		return workers;
	}

	public void setWorkers(Collection<UserDTO> workers) {
		this.workers = workers;
	}

	public Collection<UserDTO> getManagers() {
		return managers;
	}

	public void setManagers(Collection<UserDTO> managers) {
		this.managers = managers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
