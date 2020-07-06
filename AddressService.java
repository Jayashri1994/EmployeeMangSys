package com.emp.appli.web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.appli.web.Bean.Address;
import com.emp.appli.web.Repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addrRepo;
	
	/*
	 * public Address fetchAddress(int empid) { return addrRepo.findByEmp_Id(empid);
	 * 
	 * 
	 * }
	 */
	
}
