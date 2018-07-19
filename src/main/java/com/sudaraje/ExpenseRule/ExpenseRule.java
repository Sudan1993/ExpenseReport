package com.sudaraje.ExpenseRule;

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

import com.sudaraje.Country.Country;
import com.sudaraje.Expense.Expense;
import com.sudaraje.User_Designation.UserDesignation;
import com.sudaraje.Users.Users;

@Entity
@Table(name="ExpenseRule")
public class ExpenseRule {

	@Id
	@GeneratedValue
	private Long ruleId;	

	private Long maxAmount;
	@ManyToOne
	private Users user;
	
	@ManyToOne
	private Country country;
	@ManyToOne
	private Expense expense;
	
	@Override
	public String toString() {
		return "ExpenseRule [ruleId=" + ruleId + ", maxAmount=" + maxAmount + ", user=" + user + ", country=" + country
				+ ", expense=" + expense + "]";
	}
	public Long getRuleId() {
		return ruleId;
	}
	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}
	public Long getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(Long maxAmount) {
		this.maxAmount = maxAmount;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Expense getExpense() {
		return expense;
	}
	public void setExpense(Expense expense) {
		this.expense = expense;
	}
	public ExpenseRule(Long ruleId, Long maxAmount, Users user, Country country, Expense expense) {
		super();
		this.ruleId = ruleId;
		this.maxAmount = maxAmount;
		this.user = user;
		this.country = country;
		this.expense = expense;
	}
	public ExpenseRule() {}
	
	
}