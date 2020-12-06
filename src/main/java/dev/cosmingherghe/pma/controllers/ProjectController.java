package dev.cosmingherghe.pma.controllers;

import dev.cosmingherghe.pma.entities.Employee;
import dev.cosmingherghe.pma.entities.Project;

import dev.cosmingherghe.pma.services.EmployeeService;
import dev.cosmingherghe.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

        model.addAttribute("theProject", project);
        model.addAttribute("allEmployees", employees);

        return "/projects/new-project";
    }

    @PostMapping("/save")
    public String saveProject(Project project, Model model) {
        projectService.save(project);

        return "redirect:/projects/";  //used to prevent duplicate submissions
    }
}