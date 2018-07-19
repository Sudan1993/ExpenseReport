package com.sudaraje.Users;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<Users, Long>{

	List<Users> findByUsername(String username);
	
	@Query("SELECT u.password FROM Users u where u.username = :username") 
    String findPasswordByName(@Param("username") String username);
	
	public List<Users> findByUserDesignationDesid(Long desId);
}
