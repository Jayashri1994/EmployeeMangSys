package com.emp.appli.web.Bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="Addr_Gen")
	@SequenceGenerator(name="Addr_Gen",initialValue = 211,allocationSize = 100)
	private Integer aid;	
	@NotNull
	@NotEmpty
	private String addressType;
	@NotNull
	@Size(min = 10, max = 32, message = "AddressLine must be between 10 and 32 characters long")
	private String addressLine;
	@NotNull
	@NotEmpty
	private String city;
	@NotNull
	@NotEmpty
	private String state;
	@NotNull
	@NotEmpty
	private String country;
	@NotNull
	@Size(min = 6, max=6, message = "PostalCode must be a 6 digit number")
	private String postalCode;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Emp_Id")
	private Employee employee;
	
	
	public Address(Integer aid, String addressType, String addressLine, String city, String state, String country,
			String postalCode , Employee employee ) {
		super();
		this.aid = aid;
		this.addressType = addressType;
		this.addressLine = addressLine;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.employee = employee;
	}


	public Address() {
		super();
	}


	@Override
	public String toString() {
		return "Address [aid=" + aid + ", addressType=" + addressType + ", addressLine=" + addressLine + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", postalCode=" + postalCode + ", employee=" + employee
				+ "]";
	}


	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getaddressLine() {
		return addressLine;
	}
	public void setaddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
}
