package org.jclass.kroo.api.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.jclass.kroo.api.dto.AccountDto;
import org.jclass.kroo.api.dto.AccountInterestDto;
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

    private Map<String, String> sessionMap = new HashMap();

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

    public Map<String, Object> init(Map<String, Object> map) {
//    public Map<String,Object> init(String mobileNo, String deviceId) {
        String mob = refineMobileNo((String) map.get("mobileNo"));
        String deviceId = (String) map.get("deviceId");

        if (mob.length() < 10) {
            return getReady("status", "ERROR", "message", "Invalid mobile no");
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
        System.out.println("send Code " + ns + " to mobile no: " + mob);
        //System.out.println("Verification Code " + ns + " for mobile no: " + mob);

        return getReady("status", "OK", "message", "Created", "uid", saved.getId());
    }

    public Map<String, Object> verify(Map<String, Object> map) {
//    public Map<String,Object> verify(String verificationCode, String mobileNo, String deviceId) {

        long uid = Long.parseLong((String) map.get("uid"));
        String verificationCode = (String) map.get("verificationCode");

        if (verificationCode.length() != 6) {
            return getReady("status", "ERROR", "message", "Invalid Verification Code");
        }

        Account acc = accountRepo.findById(uid).get();

        if (acc.getVerificationCode().equals(verificationCode)) {
            acc.setVerified(true);
            Account saved = accountRepo.save(acc);

            return getReady("status", "OK", "message", "Update");

        } else {
            return getReady("status", "ERROR", "message", "Wrong Verification Code");
        }
    }

    public Map<String, Object> updateProfile(AccountDto obj) {

        Account acc = accountRepo.findById(obj.getUid()).get();

        acc.setFirstName(obj.getFirstName());
        acc.setLastName(obj.getLastName());
        acc.setEmail(obj.getEmail());
        acc.setPassword(obj.getPassword());

        acc.setCity(cityRepo.findById(obj.getCityId()).get());
        acc.setZip(zipRepo.findById(obj.getZipId()).get());
        Account saved = accountRepo.save(acc);

        return getReady("status", "OK", "message", "Update");
    }

    public Map<String, Object> updateAccountInterest(AccountInterestDto obj) {

        Account acc = accountRepo.findById(obj.getUid()).get();

        List<Interest> interests = interestRepo.findAllById(Arrays.asList(obj.getInterests()));

        acc.setInterests(new LinkedHashSet<>(interests));

        Account saved = accountRepo.save(acc);

        return getReady("status", "OK", "message", "Update");
    }

    public Map<String, Object> login(Map<String, Object> map) {
//    public Map<String, Object> login(String loginId, String password) {
        Account acc = accountRepo.findForLogin((String) map.get("loginId"));

        if (acc != null && acc.getPassword().equals((String) map.get("password"))) {
            String token = UUID.randomUUID().toString();

            sessionMap.put(token, acc.getId() + "");

            return getReady("status", "OK", "message", "Successful", "uid", acc.getId(), "email", acc.getEmail(), "token", token);

        } else {
            return getReady("status", "ERROR", "message", "Can not login");
        }
    }

    public Map<String, Object> logout(Map<String, Object> map) {
        String remove = sessionMap.remove(map.get("token"));
        System.out.println("logout: " + remove);
        return getReady("status", "OK", "message", "Logout");
    }

    private Map<String, Object> getReady(Object... arg) {
        Map<String, Object> mapx = new HashMap();
        for (int i = 0; i < arg.length; i += 2) {
            mapx.put((String) arg[i], arg[i + 1]);
        }
        System.out.println("sohwo b4 send" + mapx);
        return mapx;
    }
}
