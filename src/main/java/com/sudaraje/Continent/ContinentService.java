package com.sudaraje.Continent;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContinentService {

	@Autowired
	private ContinentRepository continentRepository;
	
	//create new continent
	//validate existing continent
	
	public List<Continent> findByContinentname(String continentname) {
		return continentRepository.findByContinentName(continentname);
	}

	public List<Continent> getAllContinent() {
		// TODO Auto-generated method stub
		List<Continent> continents = new ArrayList<>();		
		continentRepository.findAll().forEach(continents::add);
		return continents;
	
		
	}

	public Continent getById(Long id) {
		// TODO Auto-generated method stub
		return continentRepository.findOne(id);
	}

	public void addContinent(Continent continent) {
		// TODO Auto-generated method stub
		continentRepository.save(continent);
		
	}

	public void addContinent(Long id, Continent continent) {
		// TODO Auto-generated method stub
		continentRepository.save(continent);
	}

	public void removeContinent(Long id, Continent continent) {
		// TODO Auto-generated method stub
		continentRepository.delete(continent);
	}

	public void updateContinent(Long id, Continent continent) {
		// TODO Auto-generated method stub
		continentRepository.save(continent);
	}
	
}
