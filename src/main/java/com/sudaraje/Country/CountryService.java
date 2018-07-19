package com.sudaraje.Country;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	//create new country
	//validate existing country
	
	public List<Country> findByCountryname(String countryname) {
		return countryRepository.findByCountryName(countryname);
	}

	public List<Country> getAllCountry() {
		// TODO Auto-generated method stub
		List<Country> countrys = new ArrayList<>();		
		countryRepository.findAll().forEach(countrys::add);
		return countrys;
	
		
	}

	public Country getById(Long id) {
		// TODO Auto-generated method stub
		return countryRepository.findOne(id);
	}

	public void addCountry(Country country) {
		// TODO Auto-generated method stub
		countryRepository.save(country);
		
	}

	public void addCountry(Long id, Country country) {
		// TODO Auto-generated method stub
		countryRepository.save(country);
	}

	public void removeCountry(Long id, Country country) {
		// TODO Auto-generated method stub
		countryRepository.delete(country);
	}

	public void updateCountry(Long id, Country country) {
		// TODO Auto-generated method stub
		countryRepository.save(country);
	}
	
}
