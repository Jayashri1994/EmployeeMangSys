package com.emp.appli.web.Functions;

import java.util.Comparator;
import com.emp.appli.web.Bean.Employee;

public class EmployeeCityComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee emp1, Employee emp2) {
		int compareCity=0;
		if(emp1.getCity() !=null && emp2.getCity() != null) {	
			compareCity = emp1.getCity().compareToIgnoreCase(emp2.getCity());
		}
		
		return  compareCity;
	}

}
