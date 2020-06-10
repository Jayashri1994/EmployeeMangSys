package com.emp.appli.web.Functions;

import java.util.Comparator;
import com.emp.appli.web.Bean.Employee;

public class EmployeeComparator implements Comparator<Employee> {
	// 	Multi level comparison
	@Override
	public int compare(Employee emp1, Employee emp2) {
		 int compareName = emp1.getName().compareToIgnoreCase(emp2.getName());
		 int compareAge = emp1.getAge().compareTo(emp2.getAge());
		 int compareCity = emp1.getCity().compareToIgnoreCase(emp2.getCity());
		 int compareSalary = emp1.getSalary().compareTo(emp2.getSalary());
		 
		 
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
