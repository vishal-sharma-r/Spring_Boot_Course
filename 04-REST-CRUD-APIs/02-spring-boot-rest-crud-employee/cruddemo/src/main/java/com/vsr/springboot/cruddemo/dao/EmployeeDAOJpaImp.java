package com.vsr.springboot.cruddemo.dao;

import com.vsr.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class EmployeeDAOJpaImp implements EmployeeDAO{
    // define field for entity manager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImp(EntityManager theEntityManager)
    {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);
        // execute a query
        List<Employee> employees = theQuery.getResultList();
        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // get employee
        Employee theEmployee =  entityManager.find(Employee.class, theId);
        // return the employee
        return theEmployee;
    }
    @Override
    public Employee save(Employee theEmployee) {
        // save the Employee
        Employee dbEmployee = entityManager.merge( theEmployee);
        return dbEmployee;
    }
    @Override
    public void deleteById(int theId) {
    //find employee by id
        Employee dbEmployee = entityManager.find(Employee.class,theId);
        entityManager.remove(dbEmployee);
    }
}
