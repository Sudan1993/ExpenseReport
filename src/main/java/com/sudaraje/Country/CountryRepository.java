package com.sudaraje.Country;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CountryRepository extends CrudRepository<Country, Long>{

	List<Country> findByCountryName(String countryname);

	List<Country> findByContinentContinentId(Long id);
}
