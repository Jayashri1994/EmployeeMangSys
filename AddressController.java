package com.emp.appli.web.Controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.emp.appli.web.Bean.Address;
import com.emp.appli.web.Bean.Employee;
import com.emp.appli.web.Repository.AddressRepository;
import com.emp.appli.web.Repository.EmployeeRepository;
import com.emp.appli.web.Repository.DropDown.CityRepository;
import com.emp.appli.web.Repository.DropDown.CountryRepository;
import com.emp.appli.web.Repository.DropDown.StateRepository;

@Controller
@RequestMapping("/Address")
public class AddressController {
	
	@Autowired
	AddressRepository addrRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	CountryRepository countryRepo;
	
	@Autowired
	StateRepository stateRepo;
	
	@Autowired
	CityRepository cityRepo;

	@GetMapping("/viewAddr")
	public String showViewAddressPage(){	
		return "Addr_List";
	}
	
	@PostMapping("/viewAddr")
	public String viewAddress(int empid,ModelMap model){
		System.out.println("XXXXXXX empid"+empid);
		System.out.println("YYYY   "+empRepo.findById(empid));		
		List<Address> addressList= addrRepo.findByEmployee(empRepo.findById(empid).orElse(new Employee()));	
		//List<Address> addressList= addrRepo.findByEmployee(empid); --will not work		
		System.out.println("XX  adr"+addressList);		
		model.put("addressList",addressList);		
		
		return "Addr_List";
	}

	
	@ModelAttribute("addressType")
	   public Map<String, String> getAddressType() {	   
	      Map<String, String> addressType = new TreeMap<String, String>();
	      addressType.put("Home", "Home");
	      addressType.put("Work", "Work");
	     return addressType;
	}
	
	@GetMapping("/addUpdateAddr")

	public String showAddr_AddUpdatePage(ModelMap model) {
		model.put("address",new Address());		// Bean to View 
		System.out.println("CCC  "+countryRepo.findAllCountry());
		
		System.out.println("selected country   "+countryRepo.findCountryIdByCountryName("India"));
		
		System.out.println("state   "+stateRepo.findAllStateByCountryId(1001));
		
		System.out.println("selected state   "+ stateRepo.findStateIdByStateName("Karnataka"));
		
		System.out.println("city    "+cityRepo.findAllCityByStateId(2004));
		
		return "Addr_AddUpdate";
	}
	
	@PostMapping("/addUpdateAddr") 				// View to Bean
	public String viewAddr_AddUpdatePage(@ModelAttribute("address") @Valid Address address, BindingResult results ) {		
		System.out.println("Hsa some errorsssssssss"+results);
		if(results.hasErrors()) {
			System.out.println("Hsa some errorsssssssss");
			return "Addr_AddUpdate" ;
		}
		addrRepo.save(address);

		return "redirect:/Address/viewAddr" ;
	}
	
	@ModelAttribute("countryList")
	public List<String> getCountryList(){
		List<String> countryList = countryRepo.findAllCountry();
		System.out.println("countryList >>>>>>>>>>>  "+countryList);
		return countryList;
	}
	
	@ModelAttribute("stateList")
	public List<String> getStateList(@RequestParam (value="country", required=false) String selectedCountry,ModelMap model, @ModelAttribute("address") Address address){		// how to pass this param ??
		//String selectedCountry ="abc";
		//String selectedCountry = model.getAttribute("country");
		//System.out.println("Country       "+selectedCountry);
		//System.out.println("Value      "+model.getAttribute("country"));
		//List<String> stateList = stateRepo.findAllStateByCountryId(countryRepo.findCountryIdByCountryName(selectedCountry));	
		List<String> stateList = stateRepo.findAllState();
		
		return stateList;
	}
	
	@ModelAttribute("cityList")
	public List<String> getCityList(String selectedState){
		//List<String> cityList = cityRepo.findAllCityByStateId(stateRepo.findStateIdByStateName(selectedState));
		List<String> cityList = cityRepo.findAllCity();
		return cityList;
	}
	

	@GetMapping("/updateAddr")
	public String updateEmployeeAddress(@RequestParam int aid,ModelMap model) {
		model.addAttribute("address",addrRepo.findById(aid));
		return "Addr_AddUpdate";
	}
	
	@PostMapping("/updateAddr")
	public String updateEmployeeAddress(@ModelAttribute @Valid Address address, BindingResult results,RedirectAttributes redirectAttribute){
		if(results.hasErrors()) {
			return "Addr_AddUpdate";
		}
		addrRepo.save(address);
		
		System.out.println("empid value"+address.getEmployee().getId());
		redirectAttribute.addFlashAttribute("empid",address.getEmployee().getId());
		return "redirect:/Address/viewAddr" ;
	}
	
	@GetMapping("/deleteAllAddr")
	public String deleteAllAddress() {
		addrRepo.deleteAll();
		return "redirect:/Address/viewAddr" ;
	}
	
	@GetMapping("/deleteAddr")
	public String deleteSelectedAddress(@RequestParam int aid) {
		System.out.println( "aid >>>  "+aid);
		addrRepo.deleteById(aid);
		return "redirect:/Address/viewAddr" ;
	}
}
