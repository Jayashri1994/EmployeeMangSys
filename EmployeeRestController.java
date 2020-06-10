package com.emp.appli.web.Rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.emp.appli.web.Bean.Employee;
import com.emp.appli.web.Repository.EmployeeRepository;

@RestController
public class EmployeeRestController {
	
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello Employee";
	}
	
	// <------------------------ List ------------------------>
	
	@GetMapping("/listEmp")
	public List<Employee> listAllEmployee() {
		return empRepo.findAll();
	}
	
	//Postman Headers: {"key":"Accept","value":"application/json"}
	//Postman Headers: {"key":"Accept","value":"application/xml"}
	
	@GetMapping(path ="/listEmpXML" , produces = "application/xml")
	public List<Employee> listAllEmployeeXML() {
		return empRepo.findAll();
	}
	
	@GetMapping(path = "/listEmpJSON" , produces = "application/json")
	public List<Employee> listAllEmployeeJSON() {
		return empRepo.findAll();
	}
	
	// <------------------------ Add ------------------------>
	
	@PostMapping("/addEmp")
	public List<Employee> addEmployee(Employee emp) {
		empRepo.save(emp);
		return empRepo.findAll();		
	}
	
	@PostMapping(path = "/addEmp" , consumes = MediaType.APPLICATION_XML_VALUE, produces = "application/json")
	public List<Employee> addEmployeeJSON(@RequestBody Employee emp) {
		empRepo.save(emp);
		return empRepo.findAll();		
	}
	// {"key":"Content-Type","value":"application/xml"}
	/*<item>
	    <name>Ankith</name>
	    <age>43</age>
	    <city>CHENNAI</city>
	    <salary>56000</salary>
    </item>*/

	@PostMapping(path = "/addEmp" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/xml")
	public List<Employee> addEmployeeXML(@RequestBody Employee emp) {
		empRepo.save(emp);
		return empRepo.findAll();		
	}
	
	// {"key":"Content-Type","value":"application/json"}
	/*{
        "name": "Ankith",
        "age": 43,
        "city": "CHENNAI",
        "salary": 56000
    }*/
	
	// <------------------------ Fetch by ID------------------------>
	
	@PutMapping("/fetchEmp/{id}")
	public Employee fetchEmp(@PathVariable int id) {
		return empRepo.findById(id).orElse(new Employee());
	}
		
	
	// <------------------------ Update by ID------------------------>
	
	@PutMapping("/updateEmp/{id}")
	public List<Employee> updateEmp(@PathVariable int id, @RequestBody @Valid Employee emp) {
		System.out.println("HEYYYYYYYYY "+id);
		System.out.println("val"+emp.getCity());
		Employee empExist = empRepo.findById(id).orElse(new Employee());
		empExist.setAge(emp.getAge());
		empExist.setCity(emp.getCity());
		empExist.setName(emp.getName());
		empExist.setSalary(emp.getSalary());
		
		empRepo.save(empExist);
		return empRepo.findAll();		
	}
		

	// <------------------------ Delete ------------------------>
	
	@DeleteMapping("/deleteEmp")
	public List<Employee> deleteEmp(Employee emp) {
		empRepo.delete(emp);
		return empRepo.findAll();
	}
	
	@DeleteMapping(path = "/deleteEmp" , consumes = MediaType.APPLICATION_XML_VALUE, produces = "application/json")
	public List<Employee> deleteEmpJSON(@RequestBody Employee emp){
		empRepo.delete(emp);
		return empRepo.findAll();
	}
	
	@DeleteMapping(path = "/deleteEmp" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/xml")
	public List<Employee> deleteEmpXML(@RequestBody Employee emp) {
		empRepo.delete(emp);
		return empRepo.findAll();
	}
	
	// <------------------------ Delete BY ID ------------------------>
	
	@DeleteMapping("/deleteEmp/{id}")
	public List<Employee> deleteEmp(@PathVariable int id) {
		empRepo.deleteById(id);
		return empRepo.findAll();
	}
	// <------------------------ Delete ALL ------------------------>
	@DeleteMapping("deleteAllEmp")
	public List<Employee> deleteAllEmp(){
		empRepo.deleteAll();
		return empRepo.findAll();
	}
}
