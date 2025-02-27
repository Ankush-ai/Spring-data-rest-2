package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Employee;
import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	@RestResource(path="names")
	List<Employee> findByName(@RequestParam("name") String name);

}
