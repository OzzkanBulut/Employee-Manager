package com.demo.employeemanager.service;

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
    public Employee getEmployee(Long employeeId){
        return employeeDao.getEmployee(employeeId);
    }
    public List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();
    }
    public void addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        employeeDao.addEmployee(employee);
    }
    public void deleteEmployee(Long employeeId){
        employeeDao.deleteEmployee(employeeId);
    }
    public void updateEmployee(Employee employee){
        employeeDao.updateEmployee(employee);
    }

}
