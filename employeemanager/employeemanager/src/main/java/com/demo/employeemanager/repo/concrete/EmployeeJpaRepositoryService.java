package com.demo.employeemanager.repo.concrete;

import com.demo.employeemanager.model.Employee;
import com.demo.employeemanager.repo.abstracts.EmployeeDao;
import com.demo.employeemanager.repo.abstracts.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeJpaRepositoryService implements EmployeeDao {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeJpaRepositoryService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
       return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(Long employeeId) {
       employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee updateEmployee(Employee employee,Long employeeId) {
        employee.setId(employeeId);
        return employeeRepository.save(employee);
    }
}
