package org.jclass.kroo.api.endpoint;

import org.jclass.kroo.api.dto.AccountDto;
import org.jclass.kroo.api.dto.AccountInterestDto;
import org.jclass.kroo.api.dto.ResponseDto;
import org.jclass.kroo.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Manik
 */

@RestController
@RequestMapping("/api/account")
public class AccountApi {

    @Autowired
    private AccountService accountService;

    @PostMapping("/init")
    public ResponseDto init(@RequestParam String mobileNo, @RequestParam String deviceId) {
        //send sms to given mobile no
        return accountService.init(mobileNo, deviceId);
    }

    @PostMapping("/verify")
    public ResponseDto verify(@RequestParam String verificationCode, @RequestParam String mobileNo, @RequestParam String deviceId) {
        //get verificationCode and match if match OK,
        return accountService.verify(verificationCode, mobileNo, deviceId);
    }

    @PostMapping("/createProfile")
    public ResponseDto createProfile(@RequestBody AccountDto obj) {
        return accountService.createProfile(obj);
    }

    @PostMapping("/createAccountInterest")
    public ResponseDto createAccountInterest(@RequestBody AccountInterestDto obj) {
        return accountService.createAccountInterest(obj);
    }

    @PostMapping("/login")
    public ResponseDto login(@RequestParam String loginId, @RequestParam String password) {
        //loginId is mobile no or email
        return accountService.login(loginId, password);
    }

    @PostMapping("/logout")
    public ResponseDto logout(@RequestParam String loginId) {
        //loginId is mobile no or email
        return accountService.logout(loginId);
    }
    
//    @PutMapping("/updateProfile")
//    public ResponseDto updateProfile(@RequestBody AccountDto obj) {
//        return accountService.updateProfile(obj);
//    }
}
