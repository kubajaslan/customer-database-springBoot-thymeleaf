package com.example.dao;

import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


//could change path if needed
//@RepositoryRestResource(path="members")

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //<entity type, primary key>
    public List<Employee> findAllByOrderByLastNameAsc();
}
