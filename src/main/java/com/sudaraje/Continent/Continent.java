package com.sudaraje.Continent;

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

import com.sudaraje.User_Designation.UserDesignation;

@Entity
@Table(name="Continent")
public class Continent {

	@Id
	@Column(name = "continentId", unique = true, nullable = false)
	private Long continentId;	
	private String continentName;
	public Long getContinentId() {
		return continentId;
	}
	public void setContinentId(Long continentId) {
		this.continentId = continentId;
	}
	public String getContinentName() {
		return continentName;
	}
	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}
	@Override
	public String toString() {
		return "Expense [continentId=" + continentId + ", continentName=" + continentName + "]";
	}
	public Continent(Long continentId, String continentName) {
		super();
		this.continentId = continentId;
		this.continentName = continentName;
	}
	
	public Continent() {}
}