package com.demo.employeemanager.repo.abstracts;

import com.demo.employeemanager.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee  employee);
    Employee getEmployee(Long employeeId);
    List<Employee> getAllEmployees();

    void deleteEmployee(Long employeeId);
    void updateEmployee(Employee employee);
}
