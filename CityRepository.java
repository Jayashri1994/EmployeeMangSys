package com.emp.appli.web.Repository.DropDown;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.emp.appli.web.Bean.DropDown.City;

public interface CityRepository extends JpaRepository<City, Integer> {
	@Query("SELECT city_desc FROM City WHERE state_Id=:state_Id")
    List<String> findAllCityByStateId(@Param("state_Id") Integer state_Id);
	
	@Query("SELECT city_desc FROM City")
    List<String> findAllCity();
}
