package com.sudaraje.Country;

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

import com.sudaraje.Continent.Continent;
import com.sudaraje.Country.CountryService;


@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/continents/{contientId}/country")
	public List<Country> getAllDesignation(){
		return countryService.getAllCountry();
	}
	
	@RequestMapping("/continents/{contientId}/country/{id}")
	public Country getDesignationById(@PathVariable("id") Long id) {
		return countryService.getById(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/continents/{contientId}/country")
	public ResponseEntity<Object> addDesignation(@RequestBody Country country, @PathVariable Long contientId) {
		System.out.println(country.toString());
		country.setContinent(new Continent(contientId,""));
		if(countryService.findByCountryname(country.getCountryName()).size()!=0){
			return new ResponseEntity<>("UserName already exists !!!",HttpStatus.NOT_ACCEPTABLE);
		}
		else {
			countryService.addCountry(country);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/continents/{contientId}/country/{id}")
	public void addDesignation(@RequestBody Country country , @PathVariable Long contientId, @PathVariable Long id) {
		System.out.println(country.toString());
		country.setContinent(new Continent(contientId,""));
		countryService.updateCountry(id,country);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/continents/{contientId}/country/{id}")
	public void removeDesignation(@RequestBody Country Country , @PathVariable Long id) {
		countryService.removeCountry(id,Country);
	}
}