package com.vsr.springboot.cruddemo.service;

import com.vsr.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee>findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
