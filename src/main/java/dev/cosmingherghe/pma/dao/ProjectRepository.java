package dev.cosmingherghe.pma.dao;

import dev.cosmingherghe.pma.dto.EmployeeProject;
import dev.cosmingherghe.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Query(nativeQuery = true, value = "SELECT e.first_name as firstName, COUNT(pe.employee_id) as projectCount " +
                                        "FROM employee e left join employee_project pe ON pe.employee_id = e.employee_id " +
                                        "GROUP BY e.first_name ORDER BY 3 DESC")
    public List<EmployeeProject> employeesProjects();
}
