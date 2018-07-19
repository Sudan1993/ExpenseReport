package com.sudaraje.ExpenseRule;

import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sudaraje.Continent.Continent;
import com.sudaraje.Country.Country;
import com.sudaraje.Expense.Expense;
import com.sudaraje.User_Designation.UserDesignation;
import com.sudaraje.Users.Users;


@RestController
public class ExpenseRuleController {

	@Autowired
	private ExpenseRuleService expenseRuleService;
	
	@RequestMapping("/expenseRule")
	public List<ExpenseRule> getAllRules(){
		return expenseRuleService.getAllRules();
	}
	
	@RequestMapping("expense/{expenseId}/expenseRule/")
	public List<ExpenseRule> getUserById(@PathVariable Long expenseId) {
		return expenseRuleService.getExpenseRulesByExpenseId(expenseId);
	}

	@RequestMapping(method=RequestMethod.POST, value="/expense/{expenseId}/{user_id}/{approver_id}/{countryId}/ExpenseRule")
	public ResponseEntity<Object> addUser(@RequestBody ExpenseRule expense,@PathVariable Long expenseId,@PathVariable Long user_id,@PathVariable Long approver_id,@PathVariable Long countryId) {
		expense.setExpense(new Expense(expenseId,""));
		expense.setUser(new Users(user_id,"","","","",new UserDesignation()));
		expense.setCountry(new Country(countryId,"",new Continent()));
		System.out.println(expense.toString());
		//check whether approver has the required privilege to approve - check for Manager Designation
		UserDesignation userDesignation = expenseRuleService.findUserDesignationByUserId(approver_id);
		if(userDesignation == null || !userDesignation.getDes_name().equalsIgnoreCase("Manager"))
			return new ResponseEntity<>("Provide a valid manaer id to approve ",HttpStatus.NOT_ACCEPTABLE);
		//check whether user has the required privilege to add rules -- check for HR Designation
		userDesignation = expenseRuleService.findUserDesignationByUserId(user_id);
		Long desid = userDesignation.getDesid();
		System.out.println(expense.toString());
		if(expenseRuleService.findDesignationByDesId(desid).equals("HR")) {
			expenseRuleService.addUser(expense);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		else
			return new ResponseEntity<>("Only HR can add expense Rules",HttpStatus.NOT_ACCEPTABLE);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/expense/{expenseId}/{user_id}/{approver_id}/{countryId}/ExpenseRule/{expense_rule_id}")
	public ResponseEntity<Object> addUser1(@RequestBody ExpenseRule expense,@PathVariable Long expenseId,@PathVariable Long user_id,@PathVariable Long approver_id,@PathVariable Long countryId,@PathVariable Long expese_rule_id) {
		expense.setExpense(new Expense(expenseId,""));
		expense.setUser(new Users(user_id,"","","","",new UserDesignation()));
		expense.setCountry(new Country(countryId,"",new Continent()));//check whether approver has the required privilege to approve - check for Manager Designation
		UserDesignation userDesignation = expenseRuleService.findUserDesignationByUserId(approver_id);
		if(userDesignation == null || !userDesignation.getDes_name().equalsIgnoreCase("Manager"))
			return new ResponseEntity<>("Provide a valid manaer id to approve ",HttpStatus.NOT_ACCEPTABLE);
		//check whether user has the required privilege to add rules -- check for HR Designation
		userDesignation = expenseRuleService.findUserDesignationByUserId(user_id);
		Long desid = userDesignation.getDesid();
		System.out.println(expense.toString());
		if(expenseRuleService.findDesignationByDesId(desid).equals("HR")) {
			expenseRuleService.addUser(expense);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		else
			return new ResponseEntity<>("Only HR can edit expense Rules",HttpStatus.NOT_ACCEPTABLE);
		
	}

	
	@RequestMapping(method=RequestMethod.DELETE, value="/expense/{expenseId}/{user_id}/{approver_id}/{countryId}/ExpenseRule/{expense_rule_id}")
	public ResponseEntity<Object> removeUser(@RequestBody ExpenseRule expense,@PathVariable Long expenseId,@PathVariable Long user_id,@PathVariable Long countryId,@PathVariable Long expese_rule_id) {
		expense.setExpense(new Expense(expenseId,""));
		expense.setUser(new Users(user_id,"","","","",new UserDesignation()));
		expense.setCountry(new Country(countryId,"",new Continent()));
		UserDesignation userDesignation = expenseRuleService.findUserDesignationByUserId(user_id);
		Long desid = userDesignation.getDesid();
		if(expenseRuleService.findDesignationByDesId(desid).equals("HR")) {
			expenseRuleService.removeUser(expese_rule_id,expense);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		else
			return new ResponseEntity<>("Only HR can delete expense Rules",HttpStatus.NOT_ACCEPTABLE);
		
	}
}