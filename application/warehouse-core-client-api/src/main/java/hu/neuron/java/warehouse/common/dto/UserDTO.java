package hu.neuron.java.warehouse.common.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = -6425229278017142978L;
	
	private Long id;
	
	private String name;
	
	private String loginName;
	
	private String password;
	
	private String address;
	
	private Date birthday;
	
	private String role;
	
	public UserDTO() {
		super();
	}

	public UserDTO(Long id, String name, String loginName, String password,
			String address, Date birthday, String role) {
		super();
		this.id = id;
		this.name = name;
		this.loginName = loginName;
		this.password = password;
		this.address = address;
		this.birthday = birthday;
		this.role = role;
	}

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

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
