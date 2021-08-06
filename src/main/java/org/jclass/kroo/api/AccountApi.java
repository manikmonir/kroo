/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jclass.kroo.api;

import org.jclass.kroo.model.Account;
import org.jclass.kroo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/account")
public class AccountApi {

    @Autowired
    private AccountService accountService;

    @PostMapping("/save")
    public String save(@RequestBody Account obj) {

        accountService.save(obj);
        return "OK";
    }
}
