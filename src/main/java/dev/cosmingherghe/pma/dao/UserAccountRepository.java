package dev.cosmingherghe.pma.dao;

import dev.cosmingherghe.pma.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
}
