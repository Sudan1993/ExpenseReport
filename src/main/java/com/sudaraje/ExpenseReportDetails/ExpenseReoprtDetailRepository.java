package com.sudaraje.ExpenseReportDetails;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sudaraje.Continent.Continent;
import com.sudaraje.Country.Country;
import com.sudaraje.Expense.Expense;
import com.sudaraje.ExpenseReport.ExpenseReport;
import com.sudaraje.ExpenseRule.ExpenseRule;
import com.sudaraje.User_Designation.UserDesignation;
import com.sudaraje.Users.Users;

public interface ExpenseReoprtDetailRepository extends CrudRepository<ExpenseReportDetail, Long>{
	
	public ExpenseReport findByExpenseReportReportId(Long reportId);
	
	
	/*********** should be deleted ******************/
	@Query("SELECT u.userDesignation FROM Users u where u.userId = :userId") 
	UserDesignation findUserDesignationByUserId(@Param("userId") Long userId);
	
	@Query("SELECT u.des_name FROM UserDesignation u where u.desid = :desid") 
    String findDesignationByDesId(@Param("desid") Long desid);
	
	@Query("SELECT u FROM Users u where u.userId = :userId")
	public List<Users> findByUsersUserId(@Param("userId")Long userId);

	@Query("SELECT e FROM Expense e where e.expenseId = :expenseId")
	Expense findExpenseByExpenseId(@Param("expenseId")Long expenseId);

	@Query("SELECT c FROM Country c where c.countryId = :countryId")
	Country finCountryByCountryId(@Param("countryId")Long countryId);
	
	@Query("SELECT e FROM ExpenseRule e where e.country.countryId = :countryId and e.expense.expenseId = :expenseId")
	ExpenseRule getExpenseRule(@Param("expenseId")Long expenseId,@Param("countryId") Long countryId);
	
	@Query("SELECT u FROM Users u where u.userId = :userId")
	Users getUsersByUserId(@Param("userId") Long userId);

	@Query(value = "SELECT * FROM Users",nativeQuery=true)
	List<Object[]> getAllUsers();
	
	
}
