package dev.cosmingherghe.pma.controllers;

import dev.cosmingherghe.pma.dao.ProjectRepository;
import dev.cosmingherghe.pma.dao.UserRepository;
import dev.cosmingherghe.pma.entities.Project;

import dev.cosmingherghe.pma.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String displayHome(Model model) {

        //query database for projects
        List<Project> projects = (List<Project>) projectRepository.findAll();
        model.addAttribute("projectsList", projects);

        //query database for users
        List<User> users = (List<User>) userRepository.findAll();
        model.addAttribute("usersList", users);

        return "home";
    }
}