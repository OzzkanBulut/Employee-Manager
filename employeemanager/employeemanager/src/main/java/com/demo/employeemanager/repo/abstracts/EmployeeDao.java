package com.demo.employeemanager.repo.abstracts;

import com.demo.employeemanager.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee addEmployee(Employee  employee);
    Employee getEmployee(Long employeeId);
    List<Employee> getAllEmployees();

    void deleteEmployee(Long employeeId);
    Employee updateEmployee(Employee employee,Long employeeId);
}
