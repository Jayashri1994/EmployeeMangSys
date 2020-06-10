package com.emp.appli.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.emp.appli.web.Bean.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
