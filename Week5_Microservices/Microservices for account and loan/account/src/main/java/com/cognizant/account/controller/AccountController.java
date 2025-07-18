package com.cognizant.account.controller;


import com.cognizant.account.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {


    @GetMapping("/{number}")
    public Account getAccount(@PathVariable String number){
        return new Account(number, "savings", (float)(Math.round(1000+  Math.random()*15478)));
    }

}
