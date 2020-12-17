package dev.cosmingherghe.pma.controllers;

import dev.cosmingherghe.pma.entities.Employee;
import dev.cosmingherghe.pma.entities.Project;
import dev.cosmingherghe.pma.services.EmployeeService;
import dev.cosmingherghe.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ProjectService projectService;

    @GetMapping("/")
    public String displayEmployees(Model model){
        //query database for employees
        List<Employee> employees = (List<Employee>) employeeService.findAll();
        model.addAttribute("employeesList", employees);

        return "/employees/list-employees";
    }

    @GetMapping("/new")
    public String addNewEmployee(Model model) {

        Employee employee = new Employee();
        List<Project> projects = (List<Project>) projectService.findAll();

        model.addAttribute("theEmployee", employee);
        model.addAttribute("allProjects", projects);

        return "/employees/new-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@Valid Employee employee, Model model, Errors errors) {

        if(errors.hasErrors())
            return "/employees/new-employee";

        employeeService.save(employee);

        return "redirect:/employees/"; //to prevent duplicates
    }

    @GetMapping("/update")
    public String updateEmployee(@RequestParam("id") long id, Model model) {

        Employee employee = employeeService.findById(id);

        model.addAttribute("theEmployee", employee);

        return "/employees/new-employee";
    }

    @GetMapping("/delete")
    public String deletemployee(@RequestParam("id") long id, Model model) {

        Employee employee = employeeService.findById(id);
        employeeService.delete(employee);

        return "redirect:/employees/";
    }
}
