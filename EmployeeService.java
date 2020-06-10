package com.emp.appli.web.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emp.appli.web.Bean.Employee;
import com.emp.appli.web.Functions.EmployeeAgeComparator;
import com.emp.appli.web.Functions.EmployeeCityComparator;
import com.emp.appli.web.Functions.EmployeeComparator;
import com.emp.appli.web.Functions.EmployeeNameComparator;
import com.emp.appli.web.Functions.EmployeeSalaryComparator;
import com.emp.appli.web.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;
	
	public List<Employee> filterEmp(String filter, int age , String city, float salary){
				
		List<Employee> results = empRepo.findAll();
		
		if(filter.equals("Equals")) {
			results = results.stream().filter(item -> item.getAge() == age
					&& item.getCity().equalsIgnoreCase(city)
					&& item.getSalary() == salary).collect(Collectors.toList());		
		}
		else if(filter.equals("Greater")) {
			results = results.stream().filter(item -> item.getAge() > age
					&& item.getCity().equalsIgnoreCase(city)
					&& item.getSalary() > salary).collect(Collectors.toList());
			
		}
		else if(filter.equals("Lesser")) {
			results = results.stream().filter(item -> item.getAge() < age
					&& item.getCity().equalsIgnoreCase(city)
					&& item.getSalary() < salary).collect(Collectors.toList());
		}
	
		return results;
	
	}	
	
	
	public List<Employee> sortEmp(String sortType){
		
		List<Employee> sortResults = empRepo.findAll();
		
		switch (sortType) {
		case "idDESC":
			Collections.sort(sortResults , Collections.reverseOrder());
			break;
			
		case "nameASC":
			Collections.sort(sortResults, new EmployeeNameComparator());
			break;
			
		case "nameDESC":
			Collections.sort(sortResults, Collections.reverseOrder(new EmployeeNameComparator()));
			break;
			
		case "ageASC":
			Collections.sort(sortResults, new EmployeeAgeComparator());
			break;
			
		case "ageDESC":
			Collections.sort(sortResults, Collections.reverseOrder(new EmployeeAgeComparator()));
			break;
			
		case "cityASC":
			Collections.sort(sortResults, new EmployeeCityComparator());
			break;
			
		case "cityDESC":
			Collections.sort(sortResults, Collections.reverseOrder(new EmployeeCityComparator()));
			break;	
			
		case "salaryASC":
			Collections.sort(sortResults, new EmployeeSalaryComparator());
			break;
			
		case "salaryDESC":
			Collections.sort(sortResults, Collections.reverseOrder(new EmployeeSalaryComparator()));
			break;

		case "multiASC":
			Collections.sort(sortResults, new EmployeeComparator());
			break;
			
		case "multiDESC":
			Collections.sort(sortResults, Collections.reverseOrder(new EmployeeComparator()));
			break;
		}	
		return sortResults;
	
	}	
	
	
	
	
	
	
}
