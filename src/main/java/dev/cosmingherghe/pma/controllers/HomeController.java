package dev.cosmingherghe.pma.controllers;

import dev.cosmingherghe.pma.dao.ProjectRepository;
import dev.cosmingherghe.pma.entities.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/")
    public String displayProjects(Model model) {
        List<Project> projects = (List<Project>) projectRepository.findAll();
        model.addAttribute("projectsList", projects);

        return "home";
    }
}
