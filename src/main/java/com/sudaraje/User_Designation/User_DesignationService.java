package com.sudaraje.User_Designation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User_DesignationService {

	@Autowired
	private User_DesignationRepository userRepository;

	public List<UserDesignation> getAllDesignation() {
		// TODO Auto-generated method stub
		List<UserDesignation> topics = new ArrayList<>();
		userRepository.findAll().forEach(topics::add);
		return topics;
	}

	public UserDesignation getById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	public void addDesignation(UserDesignation userDesignation) {
		// TODO Auto-generated method stub
		userRepository.save(userDesignation);
		
	}

	public void updateDesignation(String id, UserDesignation userDesignation) {
		// TODO Auto-generated method stub
		userRepository.save(userDesignation);
	}

	public void removeDesignation(String id, UserDesignation user_designation) {
		// TODO Auto-generated method stub
		userRepository.delete(user_designation);
		
	}
		
}
