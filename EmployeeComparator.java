package com.emp.appli.web.Functions;

import java.util.Comparator;
import com.emp.appli.web.Bean.Employee;

public class EmployeeComparator implements Comparator<Employee> {
	// 	Multi level comparison
	@Override
	public int compare(Employee emp1, Employee emp2) {
		
		 int compareName = 0,compareAge = 0,compareCity = 0,compareSalary = 0 ;
		
		if (emp1.getName() != null && emp2.getName() != null){	
		 compareName = emp1.getName().compareToIgnoreCase(emp2.getName());
		}
		
		if(emp1.getAge() != null && emp2.getAge() != null) {
		 compareAge = emp1.getAge().compareTo(emp2.getAge());
		}
		
		if(emp1.getCity() !=null && emp2.getCity() != null) {		
		 compareCity = emp1.getCity().compareToIgnoreCase(emp2.getCity());
		}
		
		if( emp1.getSalary() !=null && emp2.getSalary()!=null) {
		 compareSalary = emp1.getSalary().compareTo(emp2.getSalary());
		}
		 
		 if(compareName == 0) {
			 if(compareAge == 0) {
				 if(compareCity == 0) {
					 return (compareSalary == 0) ? compareCity : compareSalary;
				 }
			 }
			 else {
				 return compareAge;
			 }
		 }
		 
		 return compareName;
	}

}
