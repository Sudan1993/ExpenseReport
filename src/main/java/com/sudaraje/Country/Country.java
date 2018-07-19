package com.sudaraje.Country;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.sudaraje.Continent.Continent;
import com.sudaraje.User_Designation.UserDesignation;

@Entity
@Table(name="Country")
public class Country {

	@Id
	@GeneratedValue
	@Column(name = "countryId", unique = true, nullable = false)
	private Long countryId;	
	public Continent getContinent() {
		return continent;
	}
	public void setContinent(Continent continent) {
		this.continent = continent;
	}
	private String countryName;
	@ManyToOne
	private Continent continent;
	public Country() {}
	public Country(Long countryId, String countryName, Continent continent) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.continent = continent;
	}
	public Long getCountryId() {
		return countryId;
	}
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + "]";
	}
	
	
}