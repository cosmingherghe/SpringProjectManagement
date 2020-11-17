package dev.cosmingherghe.pma.controllers;

import dev.cosmingherghe.pma.dao.ProjectRepository;
import dev.cosmingherghe.pma.dao.UserRepository;
import dev.cosmingherghe.pma.entities.Project;

import dev.cosmingherghe.pma.entities.User;
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
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String displayProjects(Model model) {

        //query database for projects
        List<Project> projects = (List<Project>) projectRepository.findAll();
        model.addAttribute("projectsList", projects);

        return "/projects/list-projects";
    }

    @GetMapping("/new")
    public String displayNewProjectForm(Model model) {

        //add project
        Project project = new Project();
        List<User> users = (List<User>) userRepository.findAll();

        model.addAttribute("theProject", project);
        model.addAttribute("allUsers", users);

        return "/projects/new-project";
    }

    @PostMapping("/save")
    public String saveProject(Project project, Model model) {
        projectRepository.save(project);

        return "redirect:/projects/new";  //used to prevent duplicate submissions
    }
}