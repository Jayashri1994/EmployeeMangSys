package com.emp.appli.web.Controller;

import java.util.HashMap;
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
			return "listEmp";
		}	
		if(model.containsKey("sortList")) {
			return "listEmp";
		}
		model.put("Emplist", empRepo.findAll());
		return "listEmp";
	}
	
	/*@GetMapping("/add")
	public String showAddEmployeePage() {
		return "addUpdateEmp";
	}*/
	
	//after
	
	@GetMapping("/add")
	public String showAddEmployeePage(ModelMap model) {
		model.addAttribute("emp", new Employee()); //Bean to View 
		return "addUpdateEmp";
	}
	
	@PostMapping("/add")
	public String AddEmployee(@ModelAttribute("emp")  @Valid Employee emp, BindingResult results) { // View to Bean
		if(results.hasErrors()) {
			return "addUpdateEmp";
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
		model.addAttribute("emp",empRepo.findById(id));		
		return "addUpdateEmp";
	}

	@PostMapping("/update")
	public String updateEmployee(@Valid Employee emp, BindingResult results,ModelMap model) {
		
		if(results.hasErrors()) {
			return "addUpdateEmp";
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
		return "filterEmp";
	}
	
	
	@PostMapping("/filter")
	public String FilterEmployee(String filter,@Valid @ModelAttribute("emp")  Employee emp,BindingResult results, ModelMap model,RedirectAttributes redirectAttributes){
		if(results.hasErrors()) {
			return "filterEmp";
		}		
		redirectAttributes.addFlashAttribute("filterList",empServ.filterEmp(filter,emp.getAge() ,emp.getCity(),  emp.getSalary()));
		return "redirect:/list";
	}
	
	@GetMapping("/sort")
	public String showSortEmployee() {
		return "sortEmp"; 
	}
		
	@PostMapping("/sort")
	public String sortEmployee(String sortType,RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("sortList", empServ.sortEmp(sortType));
		return "redirect:/list"; 
	}
	
}
