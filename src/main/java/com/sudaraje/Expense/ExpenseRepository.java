package com.sudaraje.Expense;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ExpenseRepository extends CrudRepository<Expense, Long>{

	List<Expense> findByExpenseName(String expensename);

	
}
