package com.sudaraje.Users;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.sudaraje.User_Designation.UserDesignation;

@Entity
@Table(name="USERS")
public class Users {

	@Id
	@GeneratedValue
	private Long userId;	

	@Override
	public String toString() {
		return "ExpenseRule [user_id=" + userId + ", password=" + password + ", mailid=" + mailid + ", username=" + username
				+ ", user_name=" + user_name + ", des_id=" + userDesignation + "]";
	}

	private String password;
	private String mailid;
	private String username;
	private String user_name;
	
	@ManyToOne
	private UserDesignation userDesignation;
	
	public Users() {}	

	public Users(Long user_id, String password, String mailid, String username, String user_name,
			UserDesignation userDesignation) {
		super();
		this.userId = user_id;
		this.password = password;
		this.mailid = mailid;
		this.username = username;
		this.user_name = user_name;
		this.userDesignation = userDesignation;
	}

	public UserDesignation getUserDesignation() {
		return userDesignation;
	}

	public void setUserDesignation(UserDesignation userDesignation) {
		this.userDesignation = userDesignation;
	}

	public String getPassword() {
		return password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long user_id) {
		this.userId = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}