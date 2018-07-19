package com.sudaraje.Expense;

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

import com.sudaraje.Expense.ExpenseService;


@RestController
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	@RequestMapping("/expenses")
	public List<Expense> getAllDesignation(){
		return expenseService.getAllExpense();
	}	
	
	@RequestMapping("/expenses/{id}")
	public Expense getDesignationById(@PathVariable("id") Long id) {
		return expenseService.getById(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/expense")
	public void addDesignation(@RequestBody Expense expense) {
		System.out.println(expense.toString());
		expenseService.addExpense(expense);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/expense/{id}")
	public void addDesignation(@RequestBody Expense Expense , @PathVariable Long id) {
		expenseService.updateExpense(id,Expense);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/expense/{id}")
	public void removeDesignation(@RequestBody Expense Expense , @PathVariable Long id) {
		expenseService.removeExpense(id,Expense);
	}
}