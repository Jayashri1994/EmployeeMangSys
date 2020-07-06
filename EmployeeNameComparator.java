package com.emp.appli.web.Functions;

import java.util.Comparator;
import com.emp.appli.web.Bean.Employee;

public class EmployeeNameComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee emp1, Employee emp2) {
		 int compareName = 0;
			
			if (emp1.getName() != null && emp2.getName() != null){	
				compareName = emp1.getName().compareToIgnoreCase(emp2.getName());
			}
			return compareName;
	}

}
