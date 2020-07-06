package com.emp.appli.web.Service;

import java.util.ArrayList;
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
	
	public float rawQueryEmp(String queryType, String name, Integer salary){
		
		float result = 0;	
		switch (queryType) {
	
	/* Aggregate Condition */
				
			case "Count":
				result = empRepo. countByName(name);				
				break;
			case "Min":
				result = empRepo.findMinSalary();
				break;
			case "Max":
				result = empRepo.findMaxSalary();
				break;				
			case "Avg":
				result = empRepo.findAvgSalary();
				break;
				
		}	

		return result;
		
	}
	
	public List<Employee> queryEmp(String queryType, String name, String city, Integer age, String pattern, Integer startAge, Integer endAge,Integer salary /*,List<Integer> ageList*/){
		
		List<Employee> queryResults = new ArrayList<>();
	
		
		switch (queryType) {

		/* Equality Condition */
		
			case "Equal":
				queryResults = empRepo.findByName(name);
				break;
			case "Is":
				queryResults = empRepo.findByNameIs(name);
				break;
			case "Equals":
				queryResults = empRepo.findByNameEquals(name);
				break;
			case "IsNot":
				queryResults = empRepo.findByNameIsNot(name);
				break;
			case "IsNull":
				queryResults = empRepo.findByNameIsNull();
				break;
			case "IsNotNull":
				queryResults = empRepo.findByNameIsNotNull();
				break;
			
		/* Sort Condition */	
			
			case "Sort":
				queryResults = empRepo.findByCityOrderByCity(city);
				break;				
			case "Asc":
				queryResults = empRepo.findByCityOrderByCityAsc(city);
				break;
			case "Desc":
				queryResults = empRepo.findByCityOrderByCityDesc(city);
				break;
				
			case "First3":
				queryResults = empRepo.findFirst3ByCity(city);
				break;				
			case "Top3":
				queryResults = empRepo.findTop3ByCity(city);
				break;
		
				
			case "Distinct":
				queryResults = empRepo.findDistinctByCity(city);
				break;				
			case "First3ByCityOrderByCityAsc":
				queryResults = empRepo.findFirst3ByCityOrderByCityAsc(city);
				break;
			case "Top3ByCityOrderByCityDesc":
				queryResults = empRepo.findTop3ByCityOrderByCityDesc(city);
				break;
				
		/* Comparison Condition */
			case "LessThan":
				queryResults = empRepo.findByAgeLessThan(age);
				break;				
			case "LessThanEqual":
				queryResults = empRepo.findByAgeLessThanEqual(age);
				break;
			case "GreaterThan":
				queryResults = empRepo.findByAgeGreaterThan(age);
				break;
				
			case "GreaterThanEqual":
				queryResults = empRepo.findByAgeGreaterThanEqual(age);
				break;				
			case "Between":
				queryResults = empRepo.findByAgeBetween(startAge, endAge);
				break;
			case "AgeIn":
				//queryResults = empRepo. findByAgeIn(ageList);
				break;
				
		/* Multiple Condition */
			case "AND":
				queryResults = empRepo. findByNameAndCity( name,  city);
				break;
				
			case "OR":
				queryResults = empRepo. findByNameOrCity( name,  city);
				break;
			case "AND_OR":
				queryResults = empRepo. findByNameAndCityOrAge( name,  city, age);
				break;
				
			case "OR_AND":
				queryResults = empRepo. findByNameOrCityAndAge( name,  city, age);
				break;
				
		/* Similarity Condition */
				
				
			case "Prefix":
				queryResults = empRepo.findByNameStartingWith( pattern);
				break;
			case "Suffix":
				queryResults = empRepo.findByNameEndingWith( pattern);
				break;
				
			case "Infix":
				queryResults = empRepo.findByNameContaining( pattern);
				break;
			case "Like":
				queryResults = empRepo.findByNameLike( pattern);
				break;
		}
		return queryResults;
	}
	
}
