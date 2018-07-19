package com.sudaraje.ExpenseReport;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudaraje.Continent.Continent;
import com.sudaraje.Country.Country;
import com.sudaraje.Expense.Expense;
import com.sudaraje.ExpenseRule.ExpenseRule;
import com.sudaraje.User_Designation.UserDesignation;
import com.sudaraje.Users.Users;

@Service
public class ExpenseReoprtService {

	@Autowired
	private ExpenseReoprtRepository expenseReoprtRepository;
	
	public List<ExpenseReport> getAllExpenseReport(){
		List<ExpenseReport> rules = new ArrayList<>();
		expenseReoprtRepository.findAll().forEach(rules::add);
		System.out.println(rules.toString());
		return rules;
	}
	
	public UserDesignation findUserDesignationByUserId(Long userId) {
		return expenseReoprtRepository.findUserDesignationByUserId(userId);
	}

	public Expense findExpenseByExpenseId(Long expenseId) {
		return expenseReoprtRepository.findExpenseByExpenseId(expenseId);
	}
	
	public String findDesignationByDesId(Long desID) {
		return expenseReoprtRepository.findDesignationByDesId(desID);
	}

	public void addUser(ExpenseReport user) {
		// TODO Auto-generated method stub
		expenseReoprtRepository.save(user);
		
	}

	public void addUser(Long id, ExpenseReport user) {
		// TODO Auto-generated method stub
		expenseReoprtRepository.save(user);
	}

	public void removeUser(Long id, ExpenseReport user) {
		// TODO Auto-generated method stub
		expenseReoprtRepository.delete(user);
	}

	public ExpenseReport getById(Long id) {
		// TODO Auto-generated method stub
		return expenseReoprtRepository.findOne(id);
	}

	public Country findCountryByCountryId(Long country_id) {
		// TODO Auto-generated method stub
		return expenseReoprtRepository.finCountryByCountryId(country_id);
	}

	public ExpenseRule getAmountFromRules(Long expenseId, Long country_id) {
		// TODO Auto-generated method stub
		return expenseReoprtRepository.getExpenseRule(expenseId,country_id);
	}

	public void addExpense(ExpenseReport expenseReport) {
		// TODO Auto-generated method stub
		expenseReoprtRepository.save(expenseReport);
	}

	public List<Long> getAllUsers() {
		// TODO Auto-generated method stub
		List<Object[]> users = new ArrayList<>();	
		users = expenseReoprtRepository.getAllUsers();
		List<Long> userId= new ArrayList<Long>();
		for (Object[] a : users) {
			
			System.out.println("Users " + a[0] + " "+ a[1]+ " " + a[2] + " "+ a[3]+ " "+ a[4] + " "+ a[5]+ " " );
			Object obj = a[0];
			String user= obj.toString();
			userId.add(Long.valueOf(user));
		}
		return userId;
		
	}

	public void delete(ExpenseReport report) {
		// TODO Auto-generated method stub
		expenseReoprtRepository.delete(report);
	}
	
}
