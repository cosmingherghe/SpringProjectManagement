package dev.cosmingherghe.pma.controllers;

import dev.cosmingherghe.pma.dao.ProjectRepository;
import dev.cosmingherghe.pma.dao.EmployeeRepository;
import dev.cosmingherghe.pma.entities.Employee;
import dev.cosmingherghe.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/")
    public String displayEmployees(Model model){
        //query database for employees
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        model.addAttribute("employeesList", employees);

        return "/employees/list-employees";
    }

    @GetMapping("/new")
    public String addNewEmployee(Model model) {

        Employee employee = new Employee();
        List<Project> projects = (List<Project>) projectRepository.findAll();

        model.addAttribute("theEmployee", employee);
        model.addAttribute("allProjects", projects);

        return "/employees/new-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(Employee employee, Model model) {

        employeeRepository.save(employee);

        return "redirect:/employees/new"; //to prevent duplicates
    }
}
