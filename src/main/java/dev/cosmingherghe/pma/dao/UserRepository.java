package dev.cosmingherghe.pma.dao;

import dev.cosmingherghe.pma.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
