package com.example.carparkdemo.service.HR;

import com.example.carparkdemo.entities.Employee;

import java.util.List;

public interface IHRService {
    String getAllEmployee();
    Employee getEmployeeById(Long id);
    String deleteEmployee(Long id);
    void addEmployee(Employee employee);
    void editEmployee(Long id);

    Employee getEmployeeByAccount(String account);

    List<Employee> getAllEmployeeByPage(int pageNumber, int pageSize);
}
