package dev.cosmingherghe.pma.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
    private long projectId;  //outsource responsability to database, to generate an incremental ID

    private String name;
    private String stage; // Complete, In Progress, Not Started
    private String description;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
                , fetch = FetchType.LAZY)
    @JoinTable(name = "employee_project",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employees;

    public Project() {
    }

    public Project(String name, String stage, String description) {
        this.name = name;
        this.stage = stage;
        this.description = description;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // convenience method:
    public void addEmployee(Employee employee) {
        if(employees == null) {
            employees = new ArrayList<>();
        }
        employees.add(employee);
    }
}
