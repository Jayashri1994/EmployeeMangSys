package com.emp.appli.web.Bean.DropDown;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class City {

	@Id
	@GeneratedValue(generator = "City_gen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "City_gen", initialValue = 2010 , allocationSize = 100)
	Integer city_Id;
	String city_desc;	
	Integer state_Id;
	
	public Integer getCity_Id() {
		return city_Id;
	}
	public void setCity_Id(Integer city_Id) {
		this.city_Id = city_Id;
	}
	public String getCity_desc() {
		return city_desc;
	}
	public void setCity_desc(String city_desc) {
		this.city_desc = city_desc;
	}
	
	public Integer getState_Id() {
		return state_Id;
	}
	public void setState_Id(Integer state_Id) {
		this.state_Id = state_Id;
	}	
	@Override
	public String toString() {
		return "City [city_Id=" + city_Id + ", city_desc=" + city_desc + ", state_Id=" + state_Id + "]";
	}
	public City() {
		super();
	}

}
