package dev.cosmingherghe.pma;

import dev.cosmingherghe.pma.dao.ProjectRepository;
import dev.cosmingherghe.pma.dao.UserRepository;
import dev.cosmingherghe.pma.entities.Project;
import dev.cosmingherghe.pma.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ProjectManagementAppApplication {

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementAppApplication.class, args);
	}

	//  seeding the database with some pre-existing data
//	@Bean
//	CommandLineRunner runner() {
//
//		return args -> {
//
//			User emp1 = new User("John", "gfgbsdf");
//			User emp2 = new User("Mike", "fdbfg");
//			User emp3 = new User("Steve", "fbfbfbfd");
//
//			User emp4 = new User("Ronald", "bfdbdb");
//			User emp5 = new User("Jim", "bzfbdf");
//			User emp6 = new User("Peter", "bfds");
//
//			User emp7 = new User("Richard", "fgargae");
//			User emp8 = new User("Honor", "aRTHBNR");
//			User emp9 = new User("Tony", "WRGVWERWE");
//
//
//			Project pro1 = new Project("Large Production Deploy", "NOTSTARTED", "This requires all hands on deck for"
//					+ "the final deployment of the software into production");
//			Project pro2 = new Project("New User Budget",  "COMPLETED", "Decide on a new User bonus budget"
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
//			pro1.addUser(emp1);
//			pro1.addUser(emp2);
//			pro2.addUser(emp3);
//			pro3.addUser(emp1);
//			pro4.addUser(emp1);
//			pro4.addUser(emp3);
//
//
//			// need to set both sides of the relationship manually
//
//			emp1.setProjects(Arrays.asList(pro1, pro3, pro4));
//			emp2.setProjects(Arrays.asList(pro1));
//			emp3.setProjects(Arrays.asList(pro2, pro4));
//
//			// save Users in database
//
//			userRepository.save(emp1);
//			userRepository.save(emp2);
//			userRepository.save(emp3);
//			userRepository.save(emp4);
//			userRepository.save(emp5);
//			userRepository.save(emp6);
//			userRepository.save(emp7);
//			userRepository.save(emp8);
//			userRepository.save(emp9);
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