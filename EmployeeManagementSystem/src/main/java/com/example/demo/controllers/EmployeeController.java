package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Employee;
import com.example.demo.services.EmployeeService;

@Controller

public class EmployeeController {

	@Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model, @RequestParam(required = false) String name) {
        if (name != null && !name.isEmpty()) {
            model.addAttribute("listEmployees", employeeService.searchEmployees(name));
        } else {
            model.addAttribute("listEmployees", employeeService.getAllEmployees());
        }
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
    
    @GetMapping("/deleteAll")
    public String deleteAllEmployees() {
        employeeService.deleteAllEmployees();
        return "redirect:/";
    }
}
