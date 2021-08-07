package org.jclass.kroo.api.service;

import java.util.Arrays;
import java.util.List;
import org.jclass.kroo.api.dto.AccountDto;
import org.jclass.kroo.api.dto.AccountInterestDto;
import org.jclass.kroo.api.dto.ResponseDto;
import org.jclass.kroo.model.Account;
import org.jclass.kroo.model.Interest;
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

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private ZipRepo zipRepo;

    @Autowired
    private InterestRepo interestRepo;

    private String refineMobileNo(String mobileNo) {
        String mob = mobileNo.trim();
        mob = mob.replace('+', ' ');
        mob = mob.replaceAll("-", "");
        mob = mob.replaceAll(" ", "");
        return mob;
    }

    public ResponseDto init(String mobileNo, String deviceId) {
        String mob = refineMobileNo(mobileNo);

        if (mob.length() < 10) {
            return new ResponseDto("Invalid Mobile No", "ERROR");
        }

        Account acc = accountRepo.findByMobileNo(mob);

        if (acc == null) {
            acc = new Account();
            acc.setMobileNo(mob);
            acc.setActive(true);
        }

        int ns = 100000 + (int) (Math.random() * 900000);
        acc.setVerificationCode(ns + "");

        Account saved = accountRepo.save(acc);
        System.out.println("Verification Code " + ns + " for mobile no: " + mob);
        return new ResponseDto("Created", "OK");
    }

    public ResponseDto verify(String verificationCode, String mobileNo, String deviceId) {

        String mob = refineMobileNo(mobileNo);

        if (mob.length() < 10) {
            return new ResponseDto("Invalid Mobile No", "ERROR");
        }

        if (verificationCode.length() != 6) {
            return new ResponseDto("Invalid Verification Code", "ERROR");
        }

        Account acc = accountRepo.findByMobileNo(mob);

        if (acc.getVerificationCode().equals(verificationCode)) {
            acc.setVerified(true);
            Account saved = accountRepo.save(acc);

            return new ResponseDto("Updated", "OK");
        } else {
            return new ResponseDto("Wrong Verification Code", "ERROR");
        }
    }

    //gen verification code, and varify
    public ResponseDto updateProfile(AccountDto obj) {

        String mob = refineMobileNo(obj.getMobileNo());

        Account acc = accountRepo.findByMobileNo(mob);

        acc.setFirstName(obj.getFirstName());
        acc.setLastName(obj.getLastName());
        acc.setEmail(obj.getEmail());
        acc.setPassword(obj.getPassword());

        acc.setCity(cityRepo.findById(obj.getCityId()).get());
        acc.setZip(zipRepo.findById(obj.getZipId()).get());
        Account saved = accountRepo.save(acc);

        return new ResponseDto("Updated", "OK");
    }

    public ResponseDto updateAccountInterest(AccountInterestDto obj) {

        String mob = refineMobileNo(obj.getMobileNo());

        Account acc = accountRepo.findByMobileNo(mob);

        List<Interest> interests = interestRepo.findAllById(Arrays.asList(obj.getInterests()));

        acc.setInterests(interests);

        Account saved = accountRepo.save(acc);

        return new ResponseDto("Updated", "OK");
    }

    public ResponseDto login(String loginId, String password) {

        Account acc = accountRepo.findForLogin(loginId);

        if (acc.getPassword().equals(password)) {
            return new ResponseDto("Updated", "OK");

        } else {
            return new ResponseDto("Can not login", "ERROR");

        }

    }

    public ResponseDto logout(String loginId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
