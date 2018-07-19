package com.sudaraje.ExpenseReportDetails;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudaraje.Continent.Continent;
import com.sudaraje.Country.Country;
import com.sudaraje.Expense.Expense;
import com.sudaraje.ExpenseReport.ExpenseReport;
import com.sudaraje.ExpenseRule.ExpenseRule;
import com.sudaraje.User_Designation.UserDesignation;
import com.sudaraje.Users.Users;

@Service
public class ExpenseReoprtDetailService {

	@Autowired
	private ExpenseReoprtDetailRepository expenseReoprtDetailRepository;
	
	public List<ExpenseReportDetail> getAllExpenseReport(){
		List<ExpenseReportDetail> rules = new ArrayList<>();
		expenseReoprtDetailRepository.findAll().forEach(rules::add);
		System.out.println(rules.toString());
		return rules;
	}
	
	
	public UserDesignation findUserDesignationByUserId(Long userId) {
		return expenseReoprtDetailRepository.findUserDesignationByUserId(userId);
	}

	public Expense findExpenseByExpenseId(Long expenseId) {
		return expenseReoprtDetailRepository.findExpenseByExpenseId(expenseId);
	}
	
	public String findDesignationByDesId(Long desID) {
		return expenseReoprtDetailRepository.findDesignationByDesId(desID);
	}

	public void addUser(ExpenseReportDetail user) {
		// TODO Auto-generated method stub
		expenseReoprtDetailRepository.save(user);
		
	}

	public void addUser(Long id, ExpenseReportDetail user) {
		// TODO Auto-generated method stub
		expenseReoprtDetailRepository.save(user);
	}

	public void removeUser(Long id, ExpenseReportDetail user) {
		// TODO Auto-generated method stub
		expenseReoprtDetailRepository.delete(user);
	}

	public ExpenseReportDetail getById(Long id) {
		// TODO Auto-generated method stub
		return expenseReoprtDetailRepository.findOne(id);
	}

	public Country findCountryByCountryId(Long country_id) {
		// TODO Auto-generated method stub
		return expenseReoprtDetailRepository.finCountryByCountryId(country_id);
	}

	public ExpenseRule getAmountFromRules(Long expenseId, Long country_id) {
		// TODO Auto-generated method stub
		return expenseReoprtDetailRepository.getExpenseRule(expenseId,country_id);
	}

	public void addExpense(ExpenseReportDetail expenseReportDetail) {
		// TODO Auto-generated method stub
		expenseReoprtDetailRepository.save(expenseReportDetail);
	}

	public List<Long> getAllUsers() {
		// TODO Auto-generated method stub
		List<Object[]> users = new ArrayList<>();	
		users = expenseReoprtDetailRepository.getAllUsers();
		List<Long> userId= new ArrayList<Long>();
		for (Object[] a : users) {
			
			System.out.println("Users " + a[0] + " "+ a[1]+ " " + a[2] + " "+ a[3]+ " "+ a[4] + " "+ a[5]+ " " );
			Object obj = a[0];
			String user= obj.toString();
			userId.add(Long.valueOf(user));
		}
		return userId;
		
	}

	public void delete(ExpenseReportDetail report) {
		// TODO Auto-generated method stub
		expenseReoprtDetailRepository.delete(report);
	}


	public ExpenseReport findByExpenseReportReportId(Long report_id) {
		// TODO Auto-generated method stub
		return expenseReoprtDetailRepository.findByExpenseReportReportId(report_id);
	}
	
}
