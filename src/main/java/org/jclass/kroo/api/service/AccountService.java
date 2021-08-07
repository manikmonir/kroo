package org.jclass.kroo.api.service;

import org.jclass.kroo.api.dto.AccountDto;
import org.jclass.kroo.api.dto.AccountInterestDto;
import org.jclass.kroo.api.dto.ResponseDto;
import org.jclass.kroo.model.Account;
import org.jclass.kroo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manik
 */

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

    public ResponseDto init(String mobileNo, String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResponseDto verify(String verificationCode, String mobileNo, String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResponseDto createAccountInterest(AccountInterestDto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResponseDto logout(String loginId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResponseDto login(String loginId, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
