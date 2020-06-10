package com.emp.appli.web.Functions;

import java.util.Comparator;
import com.emp.appli.web.Bean.Employee;

public class EmployeeAgeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		if(emp1.getAge() > emp2.getAge()) {
			return 1;
		}
		else if(emp1.getAge() < emp2.getAge()) {
			return -1;
		}
		return 0;
	}

}
