package hu.neuron.java.warehouse.core.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "warehouse")
public class Warehouse extends BaseEntity{

	private static final long serialVersionUID = -7733674037625889368L;

	private String name;
	
	@Column(name = "address_country")
	private String addressCountry;
	
	@Column(name = "address_city")
	private String addressCity;
	
	@Column(name = "address_postcode")
	private String addressPostcode;
	
	@Column(name = "address_street")
	private String addressStreet;
	
	private String number;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "work_in_sw")
	private Collection<User> workers;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_in_sw")
	private Collection<User> managers;
	
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

	public Collection<User> getWorkers() {
		return workers;
	}

	public void setWorkers(Collection<User> workers) {
		this.workers = workers;
	}

	public Collection<User> getManagers() {
		return managers;
	}

	public void setManagers(Collection<User> managers) {
		this.managers = managers;
	}
	
}
