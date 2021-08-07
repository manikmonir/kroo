/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jclass.kroo.api.endpoint;

import org.jclass.kroo.api.dto.AccountDto;
import org.jclass.kroo.api.dto.ResponseDto;
import org.jclass.kroo.model.Account;
import org.jclass.kroo.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
//todo
    @PostMapping("/createProfile")
    public ResponseDto createProfile(@RequestBody AccountDto obj) {
        return accountService.createProfile(obj);
    }

    @PutMapping("/updateProfile")
    public ResponseDto updateProfile(@RequestBody AccountDto obj) {
        return accountService.updateProfile(obj);
    }
}
