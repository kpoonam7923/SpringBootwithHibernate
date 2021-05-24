package com.myproject.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.demo.entities.Address;
import com.myproject.demo.entities.Employee;
import com.myproject.demo.repository.EmployeeRepo;

@RestController
public class Controller {
	
	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping("/")
	public String any() {
		return "<html><body>To add data<br><a href = '/addEmployee'></a><br>To get all data<br><a href = '/all'></a></body></html>";
	}
	
//	@PostMapping("/addEmp")
//	public String add(@Param("name") String ename, @Param("city") String ecity, @Param("state") String estate, @Param("country") String ecountry)
//	{
//		Address address = new Address(ecity, estate, ecountry);
//		Employee e = new Employee(ename, address);
//		repo.save(e);
//		return "Added Succesfully";
//	}
	
	//Postman
	
	@PostMapping("/employee")
	public Employee addEmp(@RequestBody Employee emp) {
		return repo.save(emp);
	}

	@GetMapping("/employee")
	public Iterable<Employee> getEmp() {
		return repo.findAll();	
	}
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmpId(@PathVariable String id) {
		return this.repo.findById(id);
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmpId(@PathVariable String id) {
		repo.deleteById(id);
	}

	@PutMapping("/employee/{id}")
	public Employee updateEmp(@RequestBody Employee emp, @PathVariable String id) {
			//emp = repo.findById(id).get();
			emp.setName(emp.getName());
			emp.setAddress(emp.getAddress());
			Address ad = new Address();
			ad.setCity(ad.getCity());
			ad.setState(ad.getState());
			ad.setCountry(ad.getCountry());

			return repo.save(emp);
		}
}
	

