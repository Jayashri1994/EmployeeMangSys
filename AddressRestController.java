package com.emp.appli.web.Rest;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.emp.appli.web.Bean.Address;
import com.emp.appli.web.Bean.Employee;
import com.emp.appli.web.Repository.AddressRepository;
import com.emp.appli.web.Repository.EmployeeRepository;

@RestController
public class AddressRestController {

	@Autowired
	AddressRepository addrRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
							// ************************ Fetch all Address ************************* 
	@GetMapping("/listAddr")
	public List<Address> listAllAddr(){
		return addrRepo.findAll();
	}

	@GetMapping("/listAddrEmp")
	public ResponseEntity<List<Address>> listAddr(){
		List<Address> address =addrRepo.findAll();
		return new ResponseEntity<>( address, HttpStatus.OK);
	}
						// ************************ Fetch Address by AID************************* 
	@GetMapping("/listAddrAID/{aid}")
	public Address fetchAddrByAid(@PathVariable Integer aid) {
		return addrRepo.findById(aid).orElse(new Address());
	}
	
						// ************************ Fetch Address List by EID************************* 
	@GetMapping("/listAddrEID/{eid}")
	public List<Address> fetchAddrByEid(@PathVariable Integer eid){ 
		return addrRepo.findByEmployee(empRepo.findById(eid).orElse(new Employee()));
	}	  
	  
	// ************************ Add single address and Fetch Address List by EID*************************
	@PostMapping("/addAddr") 
	@Consumes("application/json")
	@Produces("application/xml")
	public List<Address> saveAddress(@RequestBody @Valid Address address, @QueryParam(value = "eid") Integer eid){
		addrRepo.save(address);
		return addrRepo.findByEmployee(empRepo.findById(eid).orElse(new Employee()));
	}
	 
	// ************************ Update single address and Fetch Address List by EID*************************
	@PutMapping("/updateEmpAddr/{eid}")
	public List<Address> updateAddress(@RequestBody @Valid Address address, @PathVariable Integer eid ){
		addrRepo.save(address);
		return addrRepo.findByEmployee(empRepo.findById(eid).orElse(new Employee()));
	}
	 
	// ************************ delete single address By AID Fetch Address List by EID*************************
	@DeleteMapping("/deleteAddrByAID")
	@Consumes(MediaType.APPLICATION_XML_VALUE)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public List<Address> deleteAddrByAID(@QueryParam(value ="aid") Integer aid, @QueryParam(value ="eid") Integer eid){
		addrRepo.deleteById(aid);
		return addrRepo.findByEmployee(empRepo.findById(eid).orElse(new Employee()));
		
	}
	
	// ************************ delete all address for an Employee By EID and Fetch Address List by EID*************************
	
	@DeleteMapping(produces = "application/xml" ,path ="/deleteAddrByEID/{eid}")
	public List<Address> deleteAddrByEID(@PathVariable Integer eid ){
		//addrRepo.deleteByEmployee(empRepo.findById(eid).orElse(new Employee())); // not getting deleted
		addrRepo.deleteByEmployee(eid); // not getting deleted 
		return addrRepo.findByEmployee(empRepo.findById(eid).orElse(new Employee()));
	}
	
	// ************************ delete all address in Address table, Fetch Address List ************************
	@DeleteMapping("/deleteAllAddr")
	public List<Address> deleteAllAddr() {
		System.out.println("inside deleteAllAddr>>>>>>>>>>>>");
		addrRepo.deleteAll();
		return addrRepo.findAll();
	}

	// ************************ delete by country ************************
	@DeleteMapping("/deleteAddrByCountry")
	public List<Address> deleteAddrByCountry(@QueryParam(value = "country") String country){
		System.out.println("country >>>>>>>>>"+country);
		addrRepo.deleteByCountry(country);
		return addrRepo.findAll();
	}
	
	// ************************ delete by city and state ************************
	@DeleteMapping("/deleteAddrByCityAndState")
	public List<Address> deleteAddrByCityAndState(@QueryParam(value = "city") String city,@QueryParam(value = "state") String state){
		System.out.println("city >>>>>>"+city);
		System.out.println("state >>>>>>>>>"+state);
		addrRepo.deleteByCityAndState(city,state);
		return addrRepo.findAll();
	}
}
