package com.emp.appli.web.Repository.DropDown;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emp.appli.web.Bean.DropDown.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{
	@Query("SELECT country_desc FROM Country")
    List<String> findAllCountry();
	
	@Query("SELECT country_Id FROM Country WHERE country_desc=:country_desc")
	Integer findCountryIdByCountryName(@Param("country_desc") String country_desc);	
	
}
