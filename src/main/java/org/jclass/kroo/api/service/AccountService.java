package org.jclass.kroo.api.service;

/**
 *
 * @author Manik
 */
import org.jclass.kroo.api.dto.AccountDto;
import org.jclass.kroo.api.dto.ResponseDto;
import org.jclass.kroo.model.Account;
import org.jclass.kroo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    //gen verification code, and varify
    public ResponseDto createProfile(AccountDto obj) {

        Account acc = new Account();
        acc.setPassword(obj.getPassword());
//todo
        Account saved = accountRepo.save(acc);

        return new ResponseDto();
    }
    
    //some of info can be update
    public ResponseDto updateProfile(AccountDto obj) {

        Account acc = new Account();
        acc.setPassword(obj.getPassword());
//todo
        Account saved = accountRepo.save(acc);

        return new ResponseDto();
    }
}
