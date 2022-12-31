package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //autowired is optional since there is only a single constructor
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {

        model.addAttribute("employees", employeeService.findAll());

        return "employees/employee-list";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Employee employee = new Employee();

        model.addAttribute(employee);

        return "employees/employee-form";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);

        //post/redirect/get pattern
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
        Employee employee = employeeService.findById(id);

        model.addAttribute(employee);

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {


        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }


}
