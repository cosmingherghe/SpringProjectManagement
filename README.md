# Presentation Project (Undercontruction)

## Description
- a web base management tool that managers can use to assign multiple projects to an employee and multiple employees to a project.
- they can track the stages of the project, whether if is incomplete, in progress or complete.
- using an info-graphic to track how many projects are in the pipeline and their stage.
- integrating a google timeline chart to the project the "resources" are the projects, and we can plot each project's term as a bar.
(for the info-graphic and timeline charts I had to decode the HTML into a raw value because it is incoded when we bring out the json string from java )
- a real-world industry standard full-stack spring web application with production deployment.
- involving Spring data with Javascript using Thymeleaf.
- using Spring MVC Spring Data CRUD Repositories, Hibernate using a real database like PostgreSQL, as well as H2.

## Testing the project with the inbuilt database (H2)
1. Download the project
2. Make sure spring.profiles.active=test (profiles active is set to test) (File location is in src/main/resources/   application.properties )
3. Make sure port 8080 is not being used 
* (If you are on Mac you can check that running "lsof -n -i4TCP:8080", then, kill that process: "kill -9 PID")
* If you are on Windows you can check that running "netstat -aon | findstr 8080", then, kill that process: "taskkill /PID <PID> /F")
* (If you are on Linux you can check that running "sudo netstat -tulpn | grep LISTEN", then, kill that process: "kill -9 PID")
4. Click run on ProjectManagementAppApplication.java (File location is in  src/main/java/dev/cosmingherghe/pma/ProjectManagementAppApplication.java )
5. Open http://localhost:8080/ into your browser and have fun eploring the project
6. P.S: There are 2 users: user & admin (their password have the same name)

## Topics covered in this project include:
+ Spring Framework 5
+ Spring Boot 2
+ Spring MVC
+ Spring Data CRUD Repositories
+ Tymeleaf
+ Using Model Attributes with JavaScript in Spring
and Thymeleaf
+ Hibernate
+ Spring Annotations
+ Core Spring Concepts
+ PostgreSQL and H2 Database
+ Integration Testing
+ Spring Security
+ Google Guava Sets
+ RESTFul Web Services API
