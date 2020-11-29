package dev.cosmingherghe.pma.services;

import dev.cosmingherghe.pma.dao.UserAccountRepository;
import dev.cosmingherghe.pma.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserAccountService  {

    @Autowired
    UserAccountRepository userAccountRepository;

    public void save(UserAccount userAccount) {
        userAccountRepository.save(userAccount);
    }
}
