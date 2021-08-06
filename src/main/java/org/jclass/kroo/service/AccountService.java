package org.jclass.kroo.service;

/**
 *
 * @author Manik
 */
import org.jclass.kroo.model.Account;
import org.jclass.kroo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    public Account save(Account obj) {
        return accountRepo.save(obj);
    }
}
