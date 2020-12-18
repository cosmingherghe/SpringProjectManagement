package dev.cosmingherghe.pma.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
    @SequenceGenerator(name = "employee_generator", sequenceName = "employee_seq", allocationSize = 1)
    private Long employeeId;

    @NotBlank(message = "Please enter a valid name.")
    @Size(min=2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @Email(message = "Please enter a valid email.")
    private String email;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
            , fetch = FetchType.LAZY)
    @JoinTable(name = "project_employee",
                joinColumns = @JoinColumn(name = "employee_id"),
                inverseJoinColumns = @JoinColumn(name = "project_id"))
    @JsonIgnore
    private List<Project> projects;

    public Employee() {
    }

    public Employee(String firstName, String email) {
        this.firstName = firstName;
        this.email = email;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // convenience method:
    public void addProject(Project project) {
        if(projects == null) {
            projects = new ArrayList<>();
        }
        projects.add(project);
    }
}