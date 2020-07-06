package com.emp.appli.web.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.emp.appli.web.Bean.Employee;
import com.emp.appli.web.Repository.EmployeeRepository;
import com.emp.appli.web.Service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService empServ;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/list")
	public String listAllEmployee(ModelMap model) {	
		if(model.containsKey("filterList")) {
			return "Emp_List";
		}	
		if(model.containsKey("sortList")) {
			return "Emp_List";
		}
		if(model.containsKey("queryList")) {
			return "Emp_List";
		}

		model.put("Emplist", empRepo.findAll());
		return "Emp_List";
	}
	
	/*@GetMapping("/add")
	public String showAddEmployeePage() {
		return "Emp_AddUpdate";
	}*/
	
	//after
	
	@GetMapping("/add")
	public String showAddEmployeePage(ModelMap model) {
		model.addAttribute("emp", new Employee()); //Bean to View 
		return "Emp_AddUpdate";
	}
	
	@PostMapping("/add")
	public String AddEmployee(@ModelAttribute("emp")  @Valid Employee emp, BindingResult results) { // View to Bean
		if(results.hasErrors()) {			// View to Bean @ModelAttribute("emp")
			return "Emp_AddUpdate";
		}
		empRepo.save(emp);
		return "redirect:/list";
	}
	
	
	@GetMapping("/delete")
	public String DeleteEmployee(@RequestParam int id) {
		empRepo.deleteById(id);
		return "redirect:/list";
	}
	
	@GetMapping("/deleteAll")
	public String DeleteAllEmployee() {
		empRepo.deleteAll();
		return "redirect:/list";
	}
	
	@GetMapping("/update")
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {		
		model.addAttribute("emp",empRepo.findById(id));		// Bean to View
		return "Emp_AddUpdate";
	}

	@PostMapping("/update")
	public String updateEmployee(@Valid Employee emp, BindingResult results) {
		
		if(results.hasErrors()) {
			return "Emp_AddUpdate";
		}	
		empRepo.save(emp);
		return "redirect:/list";
	}

   @ModelAttribute("cityList")
   public Map<String, String> getCityList() {	   
      Map<String, String> cityList = new HashMap<String, String>();
      cityList.put("CHENNAI", "CHENNAI");
      cityList.put("MUMBAI", "MUMBAI");
      cityList.put("DELHI", "DELHI");
      cityList.put("BANGALORE", "BANGALORE");
      cityList.put("KOLKATA", "KOLKATA");
      return cityList;
   }
	 
	@GetMapping("/filter")
	public String showFilterEmployeePage(ModelMap model) {
		model.addAttribute("emp" ,new Employee());
		return "Emp_Filter";
	}
	
	
	@PostMapping("/filter")
	public String FilterEmployee(String filter,@Valid @ModelAttribute("emp")  Employee emp,BindingResult results, ModelMap model,RedirectAttributes redirectAttributes){
		if(results.hasErrors()) {
			return "Emp_Filter";
		}		
		redirectAttributes.addFlashAttribute("filterList",empServ.filterEmp(filter,emp.getAge() ,emp.getCity(),  emp.getSalary()));
		return "redirect:/list";
	}
	
	@GetMapping("/sort")
	public String showSortEmployee() {
		return "Emp_Sort"; 
	}
		
	@PostMapping("/sort")
	public String sortEmployee(String sortType,RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("sortList", empServ.sortEmp(sortType));
		return "redirect:/list"; 
	}
	
	
	@GetMapping("/query")
	public String showQueryPage() {
		return "Emp_Query";
	}
	
	@PostMapping("/query")
	public String queryEmployee(String queryType, String name, String city, Integer age, String pattern,
			Integer startAge, Integer endAge, /* List<Integer> ageList, */ RedirectAttributes redirectAttributes, Integer salary, ModelMap model ) {

		if(queryType.equals("Count") || queryType.equals("Min") || queryType.equals("Max") || queryType.equals("Avg") ||  queryType.equals("EmpSal") ) {
			model.put("results",empServ.rawQueryEmp(queryType, name, salary));
			return "Emp_Query_Results";
			
		}
		
		redirectAttributes.addFlashAttribute("queryList",empServ.queryEmp(queryType, name, city, age, pattern, startAge, endAge,salary/* ,ageList */));
		
		return "redirect:/list";
	}
}
