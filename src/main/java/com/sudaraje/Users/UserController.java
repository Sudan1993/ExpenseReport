package com.sudaraje.Users;

import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sudaraje.User_Designation.UserDesignation;


@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/designation/{id}/Users")
	public List<Users> getAllUsers(@PathVariable("id") Long id){
		return userService.getAllUsers(id);
	}
	
	@RequestMapping("/designation/{designationId}/Users/{id}")
	public Users getUserById(@PathVariable("id") Long id) {
		return userService.getById(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/designation/{designationId}/Users")
	public ResponseEntity<Object> addUser(@RequestBody Users user,@PathVariable Long designationId) {
		user.setUserDesignation(new UserDesignation(designationId,""));
		if(userService.findByUsername(user.getUsername()).size()!=0){
			return new ResponseEntity<>("UserName already exists !!!",HttpStatus.NOT_ACCEPTABLE);
		}
		else {
			userService.addUser(user);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value="/signup/login")
	@ResponseBody
	public ResponseEntity<Object> validateUser(@RequestBody Users user) {
		System.out.println(user.toString());
		System.out.println(userService.findByUsername(user.getUsername()).size());
		if(userService.findByUsername(user.getUsername()).size()==0){
			return new ResponseEntity<>("UserName doesnt exists !!!",HttpStatus.NOT_ACCEPTABLE);
		}
		else if(userService.findByUsername(user.getUsername()).size() == 1) {
			String password = userService.findPasswordByUsername(user.getUsername());
			System.out.println(password + "password got from the crud repository" );
			if(password.equals(user.getPassword())) {
				return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}
			else {
				return new ResponseEntity<>("UserName and Password doesnt match !!!",HttpStatus.BAD_REQUEST);
			}
		}		
		return null;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/designation/{designationId}/Users/{id}")
	public void updateUser(@RequestBody Users User , @PathVariable Long designationId,@PathVariable Long id) {
		User.setUserDesignation(new UserDesignation(designationId,""));
		userService.addUser(id,User);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/designation/{designationId}/Users/{id}")
	public void removeUser(@RequestBody Users User , @PathVariable Long id) {
		userService.removeUser(id,User);
	}
}