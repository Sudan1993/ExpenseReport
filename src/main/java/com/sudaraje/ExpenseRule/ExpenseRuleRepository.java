package com.sudaraje.ExpenseRule;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sudaraje.User_Designation.UserDesignation;

public interface ExpenseRuleRepository extends CrudRepository<ExpenseRule, Long>{
	
	@Query("SELECT u.userDesignation FROM Users u where u.userId = :userId") 
	UserDesignation findUserDesignationByUserId(@Param("userId") Long userId);
	
	@Query("SELECT u.des_name FROM UserDesignation u where u.desid = :desid") 
    String findDesignationByDesId(@Param("desid") Long desid);

	public List<ExpenseRule> findByExpenseExpenseId(Long expenseId);
	
}
