package dev.cosmingherghe.pma.controllers;

import dev.cosmingherghe.pma.entities.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @GetMapping("/new")
    public String displayNewProjectForm(Model model) {

        Project aProject = new Project();

        model.addAttribute("project", aProject);
        return "/new-project";
    }
}
