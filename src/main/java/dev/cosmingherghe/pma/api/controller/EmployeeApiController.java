package dev.cosmingherghe.pma.api.controller;

import dev.cosmingherghe.pma.entities.Employee;
import dev.cosmingherghe.pma.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public Iterable<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee findByIdEmployee(@PathVariable("id") Long id) {
        return employeeService.findByIdApi(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody @Valid Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployee(@RequestBody @Valid Employee employee) {
        return employeeService.save(employee);
    }

    @PatchMapping( path = "/{id}" , consumes = "application/json")
    public Employee partialUpdateEmployee(@RequestBody @Valid Employee patchEmployee, @PathVariable("id") Long id) {

        Employee employee = employeeService.findByIdApi(id);

        if (patchEmployee.getEmail() != null)
            employee.setEmail(patchEmployee.getEmail());

        if (patchEmployee.getFirstName() != null)
            employee.setFirstName(patchEmployee.getFirstName());

        return employeeService.save(employee);
    }
}