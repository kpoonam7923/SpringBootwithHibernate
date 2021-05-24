package com.myproject.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.myproject.demo.entities.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, String> {

}
