package com.sudaraje.Continent;

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

import com.sudaraje.Continent.ContinentService;


@RestController
public class ContinentController {

	@Autowired
	private ContinentService continentService;
	
	@RequestMapping("/continents")
	public List<Continent> getAllDesignation(){
		return continentService.getAllContinent();
	}	
	
	@RequestMapping("/continents/{id}")
	public Continent getDesignationById(@PathVariable("id") Long id) {
		return continentService.getById(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/continent")
	public void addDesignation(@RequestBody Continent continent) {
		System.out.println(continent.toString());
		continentService.addContinent(continent);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/continent/{id}")
	public void addDesignation(@RequestBody Continent Continent , @PathVariable Long id) {
		continentService.updateContinent(id,Continent);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/continent/{id}")
	public void removeDesignation(@RequestBody Continent Continent , @PathVariable Long id) {
		continentService.removeContinent(id,Continent);
	}
}