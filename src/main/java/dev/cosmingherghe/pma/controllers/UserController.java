package dev.cosmingherghe.pma.controllers;

import dev.cosmingherghe.pma.dao.UserRepository;
import dev.cosmingherghe.pma.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String displayUsers(Model model){
        //query database for users
        List<User> users = (List<User>) userRepository.findAll();
        model.addAttribute("usersList", users);

        return "/users/list-users";
    }

    @GetMapping("/new")
    public String addNewUser(Model model) {

        //add user
        User aUser = new User();
        model.addAttribute("user", aUser);

        return "/users/new-user";
    }

    @PostMapping("/save")
    public String saveUser(User user, Model model) {

        userRepository.save(user);

        return "redirect:/users/new"; //to prevent duplicates
    }
}
