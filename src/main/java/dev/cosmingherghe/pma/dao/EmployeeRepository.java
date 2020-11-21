package dev.cosmingherghe.pma.dao;

import dev.cosmingherghe.pma.dto.EmployeeProject;
import dev.cosmingherghe.pma.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query(nativeQuery = true, value = "SELECT e.first_name as firstName, COUNT(pe.employee_id) as projectCount " +
            "FROM employee e left join employee_project pe ON pe.employee_id = e.employee_id " +
            "GROUP BY e.first_name ORDER BY projectCount DESC")
    public List<EmployeeProject> employeeProjectsCount();
}
