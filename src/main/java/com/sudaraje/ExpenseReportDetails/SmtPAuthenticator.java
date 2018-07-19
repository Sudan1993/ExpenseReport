package com.sudaraje.ExpenseReportDetails;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SmtPAuthenticator extends Authenticator {
	
	public SmtPAuthenticator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public PasswordAuthentication getPasswordAuthentication() {
	 String username = "sudarcool.prabu36@gmail.com";
	 String password = "waterfalls";
	    if ((username != null) && (username.length() > 0) && (password != null) 
	      && (password.length   () > 0)) {

	        return new PasswordAuthentication(username, password);
	    }

	    return null;
	}
}
