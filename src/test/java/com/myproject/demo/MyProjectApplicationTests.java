package com.myproject.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myproject.demo.entities.Address;
import com.myproject.demo.entities.Employee;
import com.myproject.demo.repository.EmployeeRepo;

@SpringBootTest
class MyProjectApplicationTests {

	@Autowired
	EmployeeRepo repo;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void update() {
		Employee e = repo.findById("9").get();
		e.setName("Poonam");
		Address address = new Address();
		address.setCity("Amravati");
		address.setState("Maharashtra");
		address.setCountry("India");
		e.setAddress(address);
		repo.save(e);
	}
}
