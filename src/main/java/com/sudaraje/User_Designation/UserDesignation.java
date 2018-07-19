package com.sudaraje.User_Designation;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sudaraje.Users.Users;
@Entity
@Table(name="UserDesignation")
public class UserDesignation {

	@Id
	@Column(name = "desid", unique = true, nullable = false)
	private Long desid;
//	@OneToMany(targetEntity=ExpenseRule.class,mappedBy = "desid",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//	private List<ExpenseRule> users;
	
	
//	public List<ExpenseRule> getUsers() {
//		return users;
//	}

	public UserDesignation() {
	}
	

//	public void setUsers(List<ExpenseRule> users) {
//		this.users = users;
//	}

	public UserDesignation(Long des_id, String des_name) {
		super();
		this.desid = des_id;
		this.des_name = des_name;
	}


	private String des_name;

	public Long getDesid() {
		return desid;
	}

	public void setDesid(Long desid) {
		this.desid = desid;
	}

	public String getDes_name() {
		return des_name;
	}

	public void setDes_name(String des_name) {
		this.des_name = des_name;
	}

	@Override
	public String toString() {
		return "UserDesignation [desid=" + desid + ", des_name=" + des_name + "]";
	}	
}