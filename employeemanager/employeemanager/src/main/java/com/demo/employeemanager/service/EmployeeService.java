package com.demo.employeemanager.service;

import com.demo.employeemanager.exception.EmployeeNotFoundException;
import com.demo.employeemanager.model.Employee;
import com.demo.employeemanager.repo.abstracts.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public Employee getEmployee(Long employeeId) {
        boolean isPresent = false;
        for (Employee e : getAllEmployees()) {
            if (e.getId().equals(employeeId)) {
                isPresent = true;
            }
        }
        if (isPresent) {
            return employeeDao.getEmployee(employeeId);
        } else {
            throw new EmployeeNotFoundException("Employee with id:" + employeeId + " not found!");
        }
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeDao.addEmployee(employee);
    }

    public void deleteEmployee(Long employeeId) {
         employeeDao.deleteEmployee(employeeId);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

}
