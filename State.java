package com.emp.appli.web.Bean.DropDown;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "State_gen")
	@SequenceGenerator(name = "State_gen", initialValue = 3025, allocationSize = 100)
	Integer state_Id;
	String state_desc;
	Integer country_Id;
	
	public Integer getState_Id() {
		return state_Id;
	}
	public void setState_Id(Integer state_Id) {
		this.state_Id = state_Id;
	}
	public String getState_desc() {
		return state_desc;
	}
	public void setState_desc(String state_desc) {
		this.state_desc = state_desc;
	}
	public Integer getCountry_Id() {
		return country_Id;
	}
	public void setCountry_Id(Integer country_Id) {
		this.country_Id = country_Id;
	}
	@Override
	public String toString() {
		return "State [state_Id=" + state_Id + ", state_desc=" + state_desc + ", country_Id=" + country_Id + "]";
	}
	public State() {
		super();
	}
		
}
