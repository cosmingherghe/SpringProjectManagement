package dev.cosmingherghe.pma.controllers;

import dev.cosmingherghe.pma.entities.Employee;
import dev.cosmingherghe.pma.entities.Project;

import dev.cosmingherghe.pma.services.EmployeeService;
import dev.cosmingherghe.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String displayProjects(Model model) {

        //query database for projects
        List<Project> projects = (List<Project>) projectService.findAll();
        model.addAttribute("projectsList", projects);

        return "/projects/list-projects";
    }

    @GetMapping("/new")
    public String displayNewProjectForm(Model model) {

        //add project
        Project project = new Project();
        List<Employee> employees = (List<Employee>) employeeService.findAll();

        model.addAttribute("project", project);
        model.addAttribute("allEmployees", employees);

        return "/projects/new-project";
    }

    @PostMapping("/save")
    public String saveProject(@Valid Project project, Errors errors) {

        if(errors.hasErrors())
            return "/projects/new-project";

        projectService.save(project);

        return "redirect:/projects/";  //used to prevent duplicate submissions
    }

    @GetMapping("/update")
    public String updateProject(@RequestParam("id") long id, Model model) {

        Project project = projectService.findById(id);

        model.addAttribute("project", project);

        return "/projects/new-project";
    }
}