package com.sudaraje.Expense;

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
@Table(name="Expense")
public class Expense {

	@Id
	@Column(name = "expenseId", unique = true, nullable = false)
	private Long expenseId;	
	private String expenseName;
	public Long getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(Long expenseId) {
		this.expenseId = expenseId;
	}
	public String getExpenseName() {
		return expenseName;
	}
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}
	@Override
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", expenseName=" + expenseName + "]";
	}
	public Expense(Long expenseId, String expenseName) {
		super();
		this.expenseId = expenseId;
		this.expenseName = expenseName;
	}
	
	public Expense() {}
}