package dev.cosmingherghe.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.cosmingherghe.pma.dao.ProjectRepository;
import dev.cosmingherghe.pma.dao.EmployeeRepository;
import dev.cosmingherghe.pma.dto.ChartProjStageCount;
import dev.cosmingherghe.pma.dto.EmployeeProject;
import dev.cosmingherghe.pma.entities.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        //Convert projData obj into json structure for user in javascript
        Map<String, Object> map = new HashMap<>();
        List<ChartProjStageCount> projStageCounts = projectRepository.projStageCount();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonProjStageCount = objectMapper.writeValueAsString(projStageCounts);
        model.addAttribute("projStageCount", jsonProjStageCount);

        //query database for projects
        List<Project> projects = (List<Project>) projectRepository.findAll();
        model.addAttribute("projectsList", projects);

        //query database for employees
        List<EmployeeProject> employeeProjectsCount = projectRepository.employeesProjects();
        model.addAttribute("employeeListProjCount", employeeProjectsCount);

        return "main/home";
    }
}