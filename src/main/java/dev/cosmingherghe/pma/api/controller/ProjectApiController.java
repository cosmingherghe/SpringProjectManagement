package dev.cosmingherghe.pma.api.controller;

import dev.cosmingherghe.pma.entities.Project;
import dev.cosmingherghe.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/app-api/projects")
public class ProjectApiController {

    @Autowired
    ProjectService projectService;

    @GetMapping
    public Iterable<Project> getProjects() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public Project findByIdProject(@PathVariable("id") Long id) {
        return projectService.findByIdApi(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Project addProject(@RequestBody @Valid Project project) {
        return projectService.save(project);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Project updateProject(@RequestBody @Valid Project project) {
        return projectService.save(project);
    }

    @PatchMapping( path = "/{id}" , consumes = "application/json")
    public Project partialUpdateProject(@RequestBody @Valid Project patchProject, @PathVariable("id") Long id) {

        Project project = projectService.findByIdApi(id);

        if (patchProject.getName() != null)
            project.setName(patchProject.getName());

        if (patchProject.getStage() != null)
            project.setStage(patchProject.getStage());

        return projectService.save(project);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        projectService.deleteById(id);
    }
}