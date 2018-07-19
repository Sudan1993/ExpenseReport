package com.sudaraje.ExpenseReport;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sudaraje.Continent.Continent;
import com.sudaraje.Country.Country;
import com.sudaraje.Expense.Expense;
import com.sudaraje.ExpenseRule.ExpenseRule;
import com.sudaraje.User_Designation.UserDesignation;
import com.sudaraje.Users.Users;


@RestController
public class ExpenseReoprtController {

	@Autowired
	private ExpenseReoprtService expenseReoprtService;
	@RequestMapping("/expensereport")
	public List<ExpenseReport> getAllDesignation(){
		return expenseReoprtService.getAllExpenseReport();
	}	
	
	@RequestMapping("/expensereport/{id}")
	public ExpenseReport getDesignationById(@PathVariable("id") Long id) {
		return expenseReoprtService.getById(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/expense/{expense_id}/{user_id}/{country_id}/expensereport")
	public ResponseEntity<Object> addDesignation(@RequestBody ExpenseReport expenseReport , @PathVariable Long expense_id,@PathVariable Long user_id,@PathVariable Long country_id) {
		System.out.println(expenseReport.toString());
		UserDesignation userDesignation = expenseReoprtService.findUserDesignationByUserId(user_id);
		if(userDesignation == null)
			return new ResponseEntity<>("Provide a valid user id ",HttpStatus.NOT_ACCEPTABLE);
		if(userDesignation.getDes_name().equalsIgnoreCase("manager") || userDesignation.getDes_name().equalsIgnoreCase("HR"))
			return new ResponseEntity<>("HR or Manager cannot add expense Report",HttpStatus.NOT_ACCEPTABLE);
		Long desid = userDesignation.getDesid();
		expenseReport.setUser(new Users(user_id,"","","","",new UserDesignation(desid,"")));
		
		
		Expense expense = expenseReoprtService.findExpenseByExpenseId(expense_id);
		if(expense == null )
			return new ResponseEntity<>("Provide a valid expense",HttpStatus.NOT_ACCEPTABLE);
		System.out.println(expense.toString());
		expenseReport.setExpense(new Expense(expense_id,""));
		
		Country country = expenseReoprtService.findCountryByCountryId(country_id);
		if(country == null )
			return new ResponseEntity<>("Provide a valid Country",HttpStatus.NOT_ACCEPTABLE);
		System.out.println(country.toString());
		Continent continent = country.getContinent();
		expenseReport.setCountry(new Country(country_id,"",continent));
		
		ExpenseRule expenseRule = expenseReoprtService.getAmountFromRules(expense.getExpenseId(),country_id);
		if(expenseRule == null)
			return new ResponseEntity<>("Expense Rule is not present",HttpStatus.NOT_ACCEPTABLE);
		System.out.println(expenseRule.toString());
		Long amount = expenseRule.getMaxAmount();
		System.out.println(amount);
		
		if(amount<expenseReport.getAmount())
			return new ResponseEntity<>("The amount quoted is more than the allocated one",HttpStatus.NOT_ACCEPTABLE);
		
		expenseReport.setApprovalStatus(false);
		
		boolean dupRow = false;
		List<ExpenseReport> existingExpenseReports = expenseReoprtService.getAllExpenseReport();
		//System.out.println(existingExpenseReports.toString());
		for(ExpenseReport report : existingExpenseReports) {
			System.out.println("inside report for loop " + report.toString());
			if(report.getCountry().getCountryId().toString().equals(country_id.toString()) && 
					report.getUser().getUserId().toString().equals(user_id.toString()) && 
					report.getExpense().getExpenseId().toString().equals(expense_id.toString()) && 
					report.getAmount().toString().equals(expenseReport.getAmount().toString())) {
				System.out.println("inside duplicate row");
				dupRow = true;
			}
 		}
		if(!dupRow)
			expenseReoprtService.addExpense(expenseReport);
		return new ResponseEntity<>("Requested Successfully",HttpStatus.ACCEPTED);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/expense/{expense_id}/{user_id}/{country_id}/expensereport/{reportid}")
	public ResponseEntity<Object> addDesignation1(@RequestBody ExpenseReport expenseReport , @PathVariable Long expense_id,@PathVariable Long user_id,@PathVariable Long country_id,@PathVariable Long reportid) {
		System.out.println(expenseReport.toString());
		Long amountToEdit = expenseReport.getAmount();
		boolean reportExists = false;
		List<ExpenseReport> existingExpenseReports = expenseReoprtService.getAllExpenseReport();
		//System.out.println(existingExpenseReports.toString());
		for(ExpenseReport report : existingExpenseReports) {
			if(report.getReportId().toString().equals(reportid.toString())){
				reportExists = true;
			}
 		}
		
		if(!reportExists)
			return new ResponseEntity<>("Enter a valid report id", HttpStatus.NOT_ACCEPTABLE);
		expenseReport= expenseReoprtService.getById(reportid);
		expenseReport.setAmount(amountToEdit);
		UserDesignation userDesignation = expenseReoprtService.findUserDesignationByUserId(user_id);
		if(userDesignation == null)
			return new ResponseEntity<>("Provide a valid user id ",HttpStatus.NOT_ACCEPTABLE);
		if(userDesignation.getDes_name().equalsIgnoreCase("manager") || userDesignation.getDes_name().equalsIgnoreCase("HR"))
			return new ResponseEntity<>("HR or Manager cannot add expense Report",HttpStatus.NOT_ACCEPTABLE);
		Long desid = userDesignation.getDesid();
		expenseReport.setUser(new Users(user_id,"","","","",new UserDesignation(desid,"")));
		
		
		Expense expense = expenseReoprtService.findExpenseByExpenseId(expense_id);
		if(expense == null )
			return new ResponseEntity<>("Provide a valid expense",HttpStatus.NOT_ACCEPTABLE);
		System.out.println(expense.toString());
		expenseReport.setExpense(new Expense(expense_id,""));
		
		Country country = expenseReoprtService.findCountryByCountryId(country_id);
		if(country == null )
			return new ResponseEntity<>("Provide a valid Country",HttpStatus.NOT_ACCEPTABLE);
		System.out.println(country.toString());
		Continent continent = country.getContinent();
		expenseReport.setCountry(new Country(country_id,"",continent));
		
		ExpenseRule expenseRule = expenseReoprtService.getAmountFromRules(expense.getExpenseId(),country_id);
		if(expenseRule == null)
			return new ResponseEntity<>("Expense Rule is not present",HttpStatus.NOT_ACCEPTABLE);
		System.out.println(expenseRule.toString());
		Long amount = expenseRule.getMaxAmount();
		System.out.println(amount);
		
		if(amount<expenseReport.getAmount())
			return new ResponseEntity<>("The amount quoted is more than the allocated one",HttpStatus.NOT_ACCEPTABLE);
		expenseReport.setApprovalStatus(false);
		
		expenseReoprtService.addExpense(expenseReport);
		return new ResponseEntity<>("Requested Successfully",HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/expense/{user_id}/expensereport/{reportid}")
	public ResponseEntity<Object> addDesignation2(@RequestBody ExpenseReport expenseReport , @PathVariable Long user_id,@PathVariable Long reportid) {
		System.out.println(expenseReport.toString());
		boolean approvalStatus = expenseReport.isApprovalStatus();
		boolean reportExists = false;
		List<ExpenseReport> existingExpenseReports = expenseReoprtService.getAllExpenseReport();
	
		for(ExpenseReport report : existingExpenseReports) {
			if(report.getReportId().toString().equals(reportid.toString()))
				reportExists = true;
 		}
		
		if(!reportExists)
			return new ResponseEntity<>("Report id not available ", HttpStatus.NOT_ACCEPTABLE);
		
		ExpenseReport report = expenseReoprtService.getById(reportid);
		if(report == null)
			return new ResponseEntity<>("Report not available",HttpStatus.NOT_ACCEPTABLE);
		
		ExpenseRule rule = expenseReoprtService.getAmountFromRules(report.getExpense().getExpenseId(), report.getCountry().getCountryId());
		if(rule == null)
			return new ResponseEntity<>("Expense Rule Id not available",HttpStatus.NOT_ACCEPTABLE);		
		
		boolean userExists = false;
		List<Long> existingUsersIds = expenseReoprtService.getAllUsers();
		for(Long userId : existingUsersIds) {
			if(userId.toString().equals(user_id.toString()))
				userExists = true;
 		}
		
		if(!userExists)
			return new ResponseEntity<>("Enter a valid User id", HttpStatus.NOT_ACCEPTABLE);
		
		if(!rule.getUser().getUserDesignation().getDes_name().toString().equalsIgnoreCase(expenseReoprtService.findUserDesignationByUserId(user_id).getDes_name().toString())) {
			return new ResponseEntity<>("Only Manager have the privilege to approve the expense request",HttpStatus.NOT_ACCEPTABLE);
		}
		
		if(!Boolean.toString(expenseReport.isApprovalStatus()).equalsIgnoreCase("true")||Boolean.toString(expenseReport.isApprovalStatus()).equalsIgnoreCase("false")){
			return new ResponseEntity<>("Enter a valid value for the approval status",HttpStatus.NOT_ACCEPTABLE);
		}
		
		ExpenseReport reportToSave = expenseReoprtService.getById(reportid);
		System.out.println(reportToSave.toString());
		reportToSave.setApprovalStatus(approvalStatus);
		expenseReoprtService.addExpense(reportToSave);
		return new ResponseEntity<>("Approval status has been flipped ",HttpStatus.ACCEPTED);
		
	}
	
		@RequestMapping(method=RequestMethod.DELETE , value="/expensereport/{reportid}")
		public ResponseEntity<Object> deleteReport(@PathVariable Long reportid) {
			
			boolean reportExists = false;
			List<ExpenseReport> existingExpenseReports = expenseReoprtService.getAllExpenseReport();
		
			for(ExpenseReport report : existingExpenseReports) {
				if(report.getReportId().toString().equals(reportid.toString()))
					reportExists = true;
	 		}
			
			if(!reportExists)
				return new ResponseEntity<>("Enter a valid report id", HttpStatus.NOT_ACCEPTABLE);
			
			ExpenseReport report = expenseReoprtService.getById(reportid);
			expenseReoprtService.delete(report);
			return null;
			
		}
	

}