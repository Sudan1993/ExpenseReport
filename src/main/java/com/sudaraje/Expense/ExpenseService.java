package com.sudaraje.Expense;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;
	
	public List<Expense> findByExpensename(String expensename) {
		return expenseRepository.findByExpenseName(expensename);
	}

	public List<Expense> getAllExpense() {
		// TODO Auto-generated method stub
		List<Expense> expenses = new ArrayList<>();		
		expenseRepository.findAll().forEach(expenses::add);
		return expenses;
	
		
	}

	public Expense getById(Long id) {
		// TODO Auto-generated method stub
		return expenseRepository.findOne(id);
	}

	public void addExpense(Expense expense) {
		// TODO Auto-generated method stub
		expenseRepository.save(expense);
		
	}

	public void addExpense(Long id, Expense expense) {
		// TODO Auto-generated method stub
		expenseRepository.save(expense);
	}

	public void removeExpense(Long id, Expense expense) {
		// TODO Auto-generated method stub
		expenseRepository.delete(expense);
	}

	public void updateExpense(Long id, Expense expense) {
		// TODO Auto-generated method stub
		expenseRepository.save(expense);
	}
	
}
