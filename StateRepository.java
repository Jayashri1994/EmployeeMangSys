package com.emp.appli.web.Repository.DropDown;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.emp.appli.web.Bean.DropDown.State;

public interface StateRepository extends JpaRepository<State, Integer> {
	@Query("SELECT state_desc FROM State WHERE country_Id=:country_Id")
    List<String> findAllStateByCountryId(@Param("country_Id") Integer country_Id);
	
	@Query("SELECT state_desc FROM State")
    List<String> findAllState();
	
	@Query("SELECT state_Id FROM State WHERE state_desc=:state_desc")
	Integer findStateIdByStateName(@Param("state_desc") String state_desc);	
}
