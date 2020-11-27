package dev.cosmingherghe.pma.services;

import dev.cosmingherghe.pma.dao.EmployeeRepository;
import dev.cosmingherghe.pma.dto.EmployeeProject;
import dev.cosmingherghe.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<EmployeeProject> employeeProjectsCount() {
        return employeeRepository.employeeProjectsCount();
    }

    public Object findAll() {
        return employeeRepository.findAll();
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}
