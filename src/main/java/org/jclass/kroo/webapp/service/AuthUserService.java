package org.jclass.kroo.webapp.service;

/**
 *
 * @author Manik
 */
import org.jclass.kroo.model.AuthUser;
import org.jclass.kroo.repo.AuthUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService {

    @Autowired
    private AuthUserRepo accountRepo;

    public AuthUser save(AuthUser obj) {
        return accountRepo.save(obj);
    }
}
