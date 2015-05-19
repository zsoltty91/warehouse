package hu.neruon.java.warehouse.ejb.client.vo;

import java.io.Serializable;
import java.util.Date;

public class UserVO implements Serializable{

	private static final long serialVersionUID = 7592789399741719993L;
	
	private Long id;
	
	private String name;
	
	private String loginName;
	
	private String address;
	
	private Date birthday;
	
	private String role;

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
