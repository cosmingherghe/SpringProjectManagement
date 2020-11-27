package dev.cosmingherghe.pma.services;

import dev.cosmingherghe.pma.dao.ProjectRepository;
import dev.cosmingherghe.pma.dto.ChartProjStageCount;
import dev.cosmingherghe.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public List<ChartProjStageCount> projStageCount() {
        return projectRepository.projStageCount();
    }

    public Object findAll() {
        return projectRepository.findAll();
    }

    public void save(Project project) {
        projectRepository.save(project);
    }
}
