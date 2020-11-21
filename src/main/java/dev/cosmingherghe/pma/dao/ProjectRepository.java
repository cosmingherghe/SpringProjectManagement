package dev.cosmingherghe.pma.dao;

import dev.cosmingherghe.pma.dto.ChartProjStageCount;
import dev.cosmingherghe.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Query(nativeQuery = true, value = "SELECT stage, COUNT(*) AS total " +
                                        "FROM project " +
                                        "GROUP BY stage")
    public List<ChartProjStageCount> projStageCount();
}
