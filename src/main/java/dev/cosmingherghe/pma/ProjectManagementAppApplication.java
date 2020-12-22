package dev.cosmingherghe.pma;

import dev.cosmingherghe.pma.dao.EmployeeRepository;
import dev.cosmingherghe.pma.dao.ProjectRepository;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectManagementAppApplication {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagementAppApplication.class, args);
    }


    @Bean
    public ServletWebServerFactory servletContainer() {
        // Enable SSL Trafic
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };

        // Add HTTP to HTTPS redirect
        tomcat.addAdditionalTomcatConnectors(httpToHttpsRedirectConnector());

        return tomcat;
    }

    /*
    We need to redirect from HTTP to HTTPS. Without SSL, this application used
    port 8082. With SSL it will use port 8443. So, any request for 8082 needs to be
    redirected to HTTPS on 8443.
     */
    private Connector httpToHttpsRedirectConnector() {
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setScheme("http");
        connector.setPort(8082);
        connector.setSecure(false);
        connector.setRedirectPort(8443);
        return connector;
    }


//  seeding the database with some pre-existing data
//	@Bean
//	CommandLineRunner runner() {
//
//		return args -> {
//
//			Employee emp1 = new Employee("John", "gfgbsdf");
//			Employee emp2 = new Employee("Mike", "fdbfg");
//			Employee emp3 = new Employee("Steve", "fbfbfbfd");
//
//			Employee emp4 = new Employee("Ronald", "bfdbdb");
//			Employee emp5 = new Employee("Jim", "bzfbdf");
//			Employee emp6 = new Employee("Peter", "bfds");
//
//			Employee emp7 = new Employee("Richard", "fgargae");
//			Employee emp8 = new Employee("Honor", "aRTHBNR");
//			Employee emp9 = new Employee("Tony", "WRGVWERWE");
//
//
//			Project pro1 = new Project("Large Production Deploy", "NOTSTARTED", "This requires all hands on deck for"
//					+ "the final deployment of the software into production");
//			Project pro2 = new Project("New Employee Budget",  "COMPLETED", "Decide on a new Employee bonus budget"
//					+ "for the year and figureout who will be promoted");
//			Project pro3 = new Project("Office Reconstruction", "INPROGRESS", "The office building in Monroe has "
//					+ "been damaged due to hurricane in the region. This needs to be reconstructed");
//			Project pro4 = new Project("Improve Intranet Security", "INPROGRESS", "With the recent data hack, the office"
//					+ "security needs to be improved and proper security team needs to be hired for "
//					+ "implementation");
//
//
//
//			// need to set both sides of the relationship manually
//
//			pro1.addEmployee(emp1);
//			pro1.addEmployee(emp2);
//			pro2.addEmployee(emp3);
//			pro3.addEmployee(emp1);
//			pro4.addEmployee(emp1);
//			pro4.addEmployee(emp3);
//
//
//			// need to set both sides of the relationship manually
//
//			emp1.setProjects(Arrays.asList(pro1, pro3, pro4));
//			emp2.setProjects(Arrays.asList(pro1));
//			emp3.setProjects(Arrays.asList(pro2, pro4));
//
//			// save Employees in database
//
//			EmployeeRepository.save(emp1);
//			EmployeeRepository.save(emp2);
//			EmployeeRepository.save(emp3);
//			EmployeeRepository.save(emp4);
//			EmployeeRepository.save(emp5);
//			EmployeeRepository.save(emp6);
//			EmployeeRepository.save(emp7);
//			EmployeeRepository.save(emp8);
//			EmployeeRepository.save(emp9);
//
//
//			// save projects in database
//
//			projectRepository.save(pro1);
//			projectRepository.save(pro2);
//			projectRepository.save(pro3);
//			projectRepository.save(pro4);
//		};
//
//	}
}