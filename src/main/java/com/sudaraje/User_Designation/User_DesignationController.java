package com.sudaraje.User_Designation;

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


@RestController
public class User_DesignationController {
	
	@Autowired
	private User_DesignationService userService;
	
	@RequestMapping("/getDesignations")
	public List<UserDesignation> getAllDesignation(){
		return userService.getAllDesignation();
	}
	
	@RequestMapping("/designation/{id}")
	public UserDesignation getDesignationById(@PathVariable("id") Long id) {
		return userService.getById(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/designation")
	public void addDesignation(@RequestBody UserDesignation userDesignation) {
		System.out.println(userDesignation.toString());
		userService.addDesignation(userDesignation);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/designation/{id}")
	public void addDesignation(@RequestBody UserDesignation user_designation , @PathVariable String id) {
		userService.updateDesignation(id,user_designation);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/designation/{id}")
	public void removeDesignation(@RequestBody UserDesignation user_designation , @PathVariable String id) {
		userService.removeDesignation(id,user_designation);
	}
	
}