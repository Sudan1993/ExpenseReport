package com.sudaraje.ExpenseReport;

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
@Table(name="ExpenseReport")
public class ExpenseReport {

	@Id
	@GeneratedValue
	private Long reportId;	

	@ManyToOne
	private Users user;
	
	@ManyToOne
	private Expense expense;
	
	@ManyToOne
	private Country country;
	
	private boolean approvalStatus;
	
	private Long amount;

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public boolean isApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(boolean approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ExpenseReport [reportId=" + reportId + ", user=" + user + ", expense=" + expense + ", country="
				+ country + ", approvalStatus=" + approvalStatus + ", amount=" + amount + "]";
	}

	public ExpenseReport(Long reportId, Users user, Expense expense, Country country, boolean approvalStatus,
			Long amount) {
		super();
		this.reportId = reportId;
		this.user = user;
		this.expense = expense;
		this.country = country;
		this.approvalStatus = approvalStatus;
		this.amount = amount;
	}
	
	public ExpenseReport() {}
	
	
	
}