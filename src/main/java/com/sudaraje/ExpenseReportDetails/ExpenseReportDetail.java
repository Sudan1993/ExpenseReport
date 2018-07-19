package com.sudaraje.ExpenseReportDetails;

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
import com.sudaraje.ExpenseReport.ExpenseReport;
import com.sudaraje.User_Designation.UserDesignation;
import com.sudaraje.Users.Users;

@Entity
@Table(name="ExpenseReportDetail")
public class ExpenseReportDetail {

	@Id
	@GeneratedValue
	private Long detailId;	

	private Long allowanceMoney;
	private String address;
	private Long travelCost;
	private boolean detailApproval;
	
	public boolean isDetailApproval() {
		return detailApproval;
	}


	public void setDetailApproval(boolean detailApproval) {
		this.detailApproval = detailApproval;
	}

	@OneToOne
	private ExpenseReport expenseReport;


	public ExpenseReportDetail(Long detailId, Long allowanceMoney, String address, Long travelCost,
			boolean detailApproval, ExpenseReport expenseReport) {
		super();
		this.detailId = detailId;
		this.allowanceMoney = allowanceMoney;
		this.address = address;
		this.travelCost = travelCost;
		this.detailApproval = detailApproval;
		this.expenseReport = expenseReport;
	}


	public Long getDetailId() {
		return detailId;
	}


	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}


	public Long getAllowanceMoney() {
		return allowanceMoney;
	}


	public void setAllowanceMoney(Long allowanceMoney) {
		this.allowanceMoney = allowanceMoney;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Long getTravelCost() {
		return travelCost;
	}


	public void setTravelCost(Long travelCost) {
		this.travelCost = travelCost;
	}


	public ExpenseReport getExpenseReport() {
		return expenseReport;
	}


	public void setExpenseReport(ExpenseReport expenseReport) {
		this.expenseReport = expenseReport;
	}

	public ExpenseReportDetail() {
		
	}
}