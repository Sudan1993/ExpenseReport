package com.sudaraje.Users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	//create new user
	//validate existing user
	
	public List<Users> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public String findPasswordByUsername(String username) {
		return userRepository.findPasswordByName(username);
	}
	
	public List<Users> getAllUsers(){
		List<Users> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		System.out.println(users);
		return users;
	}
//	public List<ExpenseRule> getAllUsers() {
//		// TODO Auto-generated method stub
//		List<ExpenseRule> users = new ArrayList<>();
//		userRepository.findAll().forEach(users::add);
//		System.out.println(users);
//		return users;
//	}
//
//	public void insertUser(ExpenseRule user) {
//		// TODO Auto-generated method stub
//		System.out.println(user.toString());
//		userRepository.save(user);
//	}
//
//	public void deleteUser(String username) {
//		// TODO Auto-generated method stub
//		if(userRepository.findByUsername(username).size()!=0) {
//			//remove the list of users with the specified username
//			List<ExpenseRule> userList = userRepository.findByUsername(username);
//			userList.forEach(x -> userRepository.delete(x));
//		}else {
//			System.out.println("no user found with the specified name");
//		}
//			
//		
//	}

	public List<Users> getAllUsers(Long id) {
		// TODO Auto-generated method stub
		List<Users> users = new ArrayList<>();		
		userRepository.findByUserDesignationDesid(id).forEach(users::add);
		return users;
	
		
	}

	public Users getById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	public void addUser(Users user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		
	}

	public void addUser(Long id, Users user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	public void removeUser(Long id, Users user) {
		// TODO Auto-generated method stub
		userRepository.delete(user);
	}
	
}
