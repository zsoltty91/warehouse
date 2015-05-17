package hu.neuron.java.warehouse.core.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "property")
@NamedQuery(name="findPropertyByName", query = "SELECT p FROM Property p  WHERE p.name = :pName")
public class Property extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
