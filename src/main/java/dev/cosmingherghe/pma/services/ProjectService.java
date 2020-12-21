package dev.cosmingherghe.pma.services;

import dev.cosmingherghe.pma.dao.ProjectRepository;
import dev.cosmingherghe.pma.dto.ChartProjStageCount;
import dev.cosmingherghe.pma.dto.ChartProjTimeLine;
import dev.cosmingherghe.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public List<ChartProjStageCount> projStageCount() {
        return projectRepository.projStageCount();
    }

    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public Project findByIdApi(Long id) {
        return projectRepository.findById(id).get();
    }

    public void deleteById(Long id) {

        try {
            projectRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {

        }
    }

    public Project findById(Long id) { return projectRepository.findById(id).get(); }

    public List<ChartProjTimeLine> getProjTimeLineData() { return  projectRepository.projTimeLineData(); }
}