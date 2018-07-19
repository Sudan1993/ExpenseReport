package com.sudaraje.ExpenseRule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudaraje.User_Designation.UserDesignation;
import com.sudaraje.Users.Users;

@Service
public class ExpenseRuleService {

	@Autowired
	private ExpenseRuleRepository expenseRuleRepository;
	
	public List<ExpenseRule> getAllRules(){
		List<ExpenseRule> rules = new ArrayList<>();
		expenseRuleRepository.findAll().forEach(rules::add);
		System.out.println(rules.toString());
		return rules;
	}
	
	public UserDesignation findUserDesignationByUserId(Long userId) {
		return expenseRuleRepository.findUserDesignationByUserId(userId);
	}

	public String findDesignationByDesId(Long desID) {
		return expenseRuleRepository.findDesignationByDesId(desID);
	}
	public List<ExpenseRule> getExpenseRulesByExpenseId(Long id) {
		// TODO Auto-generated method stub
		List<ExpenseRule> rules = new ArrayList<>();
		expenseRuleRepository.findByExpenseExpenseId(id).forEach(rules::add);
		System.out.println(rules.toString());
		return rules;		
	}

	public void addUser(ExpenseRule user) {
		// TODO Auto-generated method stub
		expenseRuleRepository.save(user);
		
	}

	public void addUser(Long id, ExpenseRule user) {
		// TODO Auto-generated method stub
		expenseRuleRepository.save(user);
	}

	public void removeUser(Long id, ExpenseRule user) {
		// TODO Auto-generated method stub
		expenseRuleRepository.delete(user);
	}

	
}
