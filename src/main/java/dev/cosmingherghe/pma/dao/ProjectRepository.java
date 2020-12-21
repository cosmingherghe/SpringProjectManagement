package dev.cosmingherghe.pma.dao;

import dev.cosmingherghe.pma.dto.ChartProjStageCount;
import dev.cosmingherghe.pma.dto.ChartProjTimeLine;
import dev.cosmingherghe.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

    @Query(nativeQuery = true, value = "SELECT stage, COUNT(*) AS total " +
                                        "FROM project " +
                                        "GROUP BY stage")
    public List<ChartProjStageCount> projStageCount();

    @Override
    public List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT name, start_date as startDate, end_date as endDate" +
            "FROM project " +
            "GROUP BY start_date")
    public List<ChartProjTimeLine> projTimeLineData();

}
