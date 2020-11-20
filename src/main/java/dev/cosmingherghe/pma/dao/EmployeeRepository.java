package dev.cosmingherghe.pma.dao;

import dev.cosmingherghe.pma.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
