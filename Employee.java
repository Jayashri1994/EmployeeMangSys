package com.emp.appli.web.Bean;

import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Employee implements Comparable<Employee>{
	@TableGenerator(name = "Employee_Gen", pkColumnName = "GEN_ID", valueColumnName = "GEN_VAL",
							pkColumnValue = "Emp_Gen", initialValue = 110, allocationSize = 100)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "Employee_Gen")
	private int id;
	
	//@NotNull(message = "Name may not be null")
	//@NotEmpty(message = "Name may not be empty")
	@Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long") 
	private String name;
	
	@NotNull(message = "Age may not be null")
	private Integer age;
	
	//@NotNull(message = "City may not be null")
	@NotEmpty(message = "City may not be empty")
	private String city;
	
	@NotNull(message = "Salary may not be null")
	private Integer salary;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public Employee(String name, int age, String city, int salary) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", city=" + city + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee e) {
		if(this.id == e.getId()) {
			return 0;
		}
		else if(this.id > e.getId()) {
			return 1;
		}
		else{
			return -1;
		}
	}

}
