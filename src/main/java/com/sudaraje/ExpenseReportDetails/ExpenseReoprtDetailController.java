package com.sudaraje.ExpenseReportDetails;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sudaraje.ExpenseReport.ExpenseReport;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@RestController
public class ExpenseReoprtDetailController {

	@Autowired
	private ExpenseReoprtDetailService expenseReoprtDetailService;
	@RequestMapping("/expensereportdetail")
	public List<ExpenseReportDetail> getAllDesignation(){
		return expenseReoprtDetailService.getAllExpenseReport();
	}	
	
	@RequestMapping("/expensereportdetail/{id}")
	public ExpenseReportDetail getDesignationById(@PathVariable("id") Long id) {
		return expenseReoprtDetailService.getById(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/expensereportdetail/{report_id}")
	public ResponseEntity<Object> addDesignation(@RequestBody ExpenseReportDetail expenseReportDetail , @PathVariable Long report_id) {
		System.out.println(expenseReportDetail.toString());
		ExpenseReport expenseReport = expenseReoprtDetailService.findByExpenseReportReportId(report_id);
		if(expenseReport == null)
			return new ResponseEntity<>("Report Id doenst exists",HttpStatus.NOT_ACCEPTABLE);
		if(!(expenseReport.getAmount()>=expenseReportDetail.getAllowanceMoney()) || !(expenseReport.getAmount()>=expenseReportDetail.getTravelCost()))
			return new ResponseEntity<>("Quoted Amount is lesser ",HttpStatus.NOT_ACCEPTABLE);
		expenseReportDetail.setExpenseReport(expenseReport);
		expenseReoprtDetailService.addExpense(expenseReportDetail);
		return new ResponseEntity<>("Requested Successfully",HttpStatus.ACCEPTED);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/expensereportdetail/{report_id}/{detail_id}")
	public ResponseEntity<Object> addDesignation1(@RequestBody ExpenseReportDetail expenseReportDetail,@PathVariable Long report_id , @PathVariable Long detail_id) throws MessagingException, UnsupportedEncodingException {
		System.out.println(expenseReportDetail.toString());
		ExpenseReport expenseReport = expenseReoprtDetailService.findByExpenseReportReportId(report_id);
		if(expenseReport == null)
			return new ResponseEntity<>("Report Id doenst exists",HttpStatus.NOT_ACCEPTABLE);
		if(!(expenseReport.getAmount()>=expenseReportDetail.getAllowanceMoney()) || !(expenseReport.getAmount()>=expenseReportDetail.getTravelCost()))
			return new ResponseEntity<>("Quoted Amount is lesser ",HttpStatus.NOT_ACCEPTABLE);
		expenseReportDetail.setExpenseReport(expenseReport);
		expenseReoprtDetailService.addExpense(expenseReportDetail);
		return new ResponseEntity<>("Requested succesffuly",HttpStatus.ACCEPTED);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/expensereportdetail/{user_id}/{detail_id}}")
	public ResponseEntity<Object> addDesignation1(@RequestBody ExpenseReportDetail expenseReportDetail,@PathVariable Long report_id ,@PathVariable Long user_id, @PathVariable Long detail_id) throws MessagingException, UnsupportedEncodingException {
		System.out.println(expenseReportDetail.toString());
		ExpenseReportDetail expenseReportDetail1 = expenseReoprtDetailService.getById(report_id);
		if(expenseReportDetail == null)
			return new ResponseEntity<>("Report Id doenst exists",HttpStatus.NOT_ACCEPTABLE);
		
		expenseReportDetail1.setDetailApproval(expenseReportDetail.isDetailApproval()); 
		expenseReoprtDetailService.addExpense(expenseReportDetail);
		
		if(expenseReportDetail.isDetailApproval()) {
			final String fromEmail = "sudarcool.prabu36@gmail.com"; //requires valid gmail id
			final String password = "password"; // correct password for gmail id
			final String toEmail = "example@gmail.com"; // can be any email id 
			
			System.out.println("SSLEmail Start");
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
			props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
			props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
			props.put("mail.smtp.port", "465"); //SMTP Port
			
			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(fromEmail, password);
						}
					});
			System.out.println("Session created");
		    EmailUtil.sendEmail(session, toEmail,"SSLEmail Testing Subject", "SSLEmail Testing Body");
			}

		return new ResponseEntity<>("Requested Successfully",HttpStatus.ACCEPTED);
		
	}
	
	
		@RequestMapping(method=RequestMethod.DELETE , value="/expensereportdetail/{detail_id}")
		public ResponseEntity<Object> deleteReport(@PathVariable Long detail_id) {
			
			boolean detailExists = false;
			List<ExpenseReportDetail> existingExpenseReports = expenseReoprtDetailService.getAllExpenseReport();
		
			for(ExpenseReportDetail detail : existingExpenseReports) {
				if(detail.getDetailId().toString().equals(detail.toString()))
					detailExists = true;
	 		}
			
			if(!detailExists)
				return new ResponseEntity<>("Enter a valid report id", HttpStatus.NOT_ACCEPTABLE);
			
			ExpenseReportDetail report = expenseReoprtDetailService.getById(detail_id);
			expenseReoprtDetailService.delete(report);
			return null;
			
		}
	

}