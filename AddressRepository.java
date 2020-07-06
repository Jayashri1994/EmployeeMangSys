package com.emp.appli.web.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import com.emp.appli.web.Bean.Address;
import com.emp.appli.web.Bean.Employee;

@Repository
//@Component  -- all annotation will work 
//@Controller
public interface AddressRepository extends JpaRepository<Address, Integer>{
	List<Address> findByEmployee(Employee emp);
	
	//List<Address> findByEmployee(Integer eid);  --will not work
	
	List<Address> findByCountry(String country);

	@Transactional
	@Modifying
	@Query("DELETE FROM Address WHERE EMP_ID = :EMP_ID")
	void deleteByEmployee(@Param(value = "EMP_ID") Integer EMP_ID); 
	
	@Transactional
	Integer deleteByCountry(String country);
	//returns the count of deleted records.
	
	@Transactional
	List<Address> deleteByCityAndState(String city, String state);
	//returns a list of deleted records.
	
	
}
