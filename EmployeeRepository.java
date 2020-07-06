package com.emp.appli.web.Repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.emp.appli.web.Bean.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> , CrudRepository<Employee, Integer>{
	//Derived Query
	
	//1.Equality Condition Keywords

	List<Employee> findByName(String name);
	List<Employee> findByNameEquals(String name);


	List<Employee> findByNameIs(String name);
	List<Employee> findByNameIsNot(String name);

	// 2.NULL check 
	List<Employee> findByNameIsNull();
	List<Employee> findByNameIsNotNull();

	//3.Similarity Condition Keywords

	List<Employee> findByNameStartingWith(String prefix);
	List<Employee> findByNameEndingWith(String suffix);
	List<Employee> findByNameContaining(String infix);

	//Note: that all conditions above are called predefined pattern expressions. So, we don't need to add % operator inside the argument when these methods are called.

	List<Employee> findByNameLike(String likePattern); // need to add %

	//4.Comparison Condition Keywords
	// we can use LessThan and LessThanEqual keywords to compare the records with the given value using the < and <= operators:

	List<Employee> findByAgeLessThan(Integer age);
	List<Employee> findByAgeLessThanEqual(Integer age);

	List<Employee> findByAgeGreaterThan(Integer age);
	List<Employee> findByAgeGreaterThanEqual(Integer age);

	List<Employee> findByAgeBetween(Integer starAge, Integer endAge);

	List<Employee> findByAgeIn(Collection<Integer> ages);


	//List<User> findByBirthDateAfter(ZonedDateTime birthDate);
	//List<User> findByBirthDateBefore(ZonedDateTime birthDate);


	//5.Multiple Condition Expressions
	//We can combine as many expressions as we need by using And and Or keywords:

	List<Employee> findByNameOrCity(String name, String city);
	List<Employee> findByNameAndCity(String name, String city);
	
	List<Employee> findByNameOrCityAndAge(String name, String city, Integer age);
	List<Employee> findByNameAndCityOrAge(String name, String city, Integer age);


	//6.Sorting the Results
	// We could ask that the users be sorted alphabetically by their name using OrderBy:

	List<Employee> findByCityOrderByCity(String city);
	List<Employee> findByCityOrderByCityAsc(String city);
	List<Employee> findByCityOrderByCityDesc(String city);

	//7.Limiting the result size of a query with Top and First

	List<Employee> findFirst3ByCity(String city);
	List<Employee> findTop3ByCity(String city);


	// 8. Aggregate 

	int countByName(String Name); 
	
	@Query("SELECT AVG(salary) FROM Employee")
    float findAvgSalary();
	
	@Query("SELECT MIN(salary) FROM Employee")
    int findMinSalary();
	
	@Query("SELECT MAX(salary) FROM Employee")
    int findMaxSalary();
	
	
	// 9. The limiting expressions also support the Distinct keyword.

	List<Employee> findDistinctByCity(String city);

	// 10. Big query 
	List<Employee> findFirst3ByCityOrderByCityAsc(String city);
	List<Employee> findTop3ByCityOrderByCityDesc(String city);
}
