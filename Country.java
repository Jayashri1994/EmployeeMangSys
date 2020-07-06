package com.emp.appli.web.Bean.DropDown;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Country_gen")
	@SequenceGenerator(name = "Country_gen", initialValue = 1003, allocationSize = 100)
	Integer country_Id;
	String country_code;
	String country_desc;
	
	public Integer getCountry_Id() {
		return country_Id;
	}
	public void setCountry_Id(Integer country_Id) {
		this.country_Id = country_Id;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getCountry_desc() {
		return country_desc;
	}
	public void setCountry_desc(String country_desc) {
		this.country_desc = country_desc;
	}
	@Override
	public String toString() {
		return "Country [country_Id=" + country_Id + ", country_code=" + country_code + ", country_desc=" + country_desc
				+ "]";
	}
	public Country() {
		super();
	}

}
