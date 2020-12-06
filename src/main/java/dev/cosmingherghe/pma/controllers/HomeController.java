package dev.cosmingherghe.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.cosmingherghe.pma.dao.ProjectRepository;
import dev.cosmingherghe.pma.dao.EmployeeRepository;
import dev.cosmingherghe.pma.dto.ChartProjStageCount;
import dev.cosmingherghe.pma.dto.EmployeeProject;
import dev.cosmingherghe.pma.entities.Project;

import dev.cosmingherghe.pma.services.EmployeeService;
import dev.cosmingherghe.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Value("${version}")
    private String projVersion;

    @Autowired
    ProjectService projectService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        model.addAttribute("projVersionNumber", projVersion);

        //Convert projData obj into json structure for user in javascript
        Map<String, Object> map = new HashMap<>();
        List<ChartProjStageCount> projStageCounts = projectService.projStageCount();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonProjStageCount = objectMapper.writeValueAsString(projStageCounts);
        model.addAttribute("projStageCount", jsonProjStageCount);

        //query database for projects
        List<Project> projects = (List<Project>) projectService.findAll();
        model.addAttribute("projectsList", projects);

        //query database for employees
        List<EmployeeProject> employeeProjectsCount = employeeService.employeeProjectsCount();
        model.addAttribute("employeeListProjCount", employeeProjectsCount);

        return "main/home";
    }
}