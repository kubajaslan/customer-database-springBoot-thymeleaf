package com.example.service;

import com.example.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public void save(Employee customer);

    public Employee findById(int id);

    public void deleteById(int id);


}
