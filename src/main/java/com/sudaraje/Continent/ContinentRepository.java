package com.sudaraje.Continent;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ContinentRepository extends CrudRepository<Continent, Long>{

	List<Continent> findByContinentName(String continentname);

	
}
