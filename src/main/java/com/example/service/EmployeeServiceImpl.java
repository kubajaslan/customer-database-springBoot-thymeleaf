package com.example.service;

import com.example.dao.EmployeeRepository;
import com.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;

        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Could not find employee id - " + id);
        }
        return employee;
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }


}
