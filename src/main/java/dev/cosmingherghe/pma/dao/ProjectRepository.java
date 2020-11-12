package dev.cosmingherghe.pma.dao;

import dev.cosmingherghe.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
