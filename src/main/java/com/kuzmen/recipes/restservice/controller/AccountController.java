package com.kuzmen.recipes.restservice.controller;

import com.kuzmen.recipes.restservice.service.AccountService;
import com.kuzmen.recipes.restservice.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET, params = {"name", "password","email"})
    public ResponseMessage register(@RequestParam("name") String name,
                         @RequestParam("password") String password,
                         @RequestParam("email") String email) {

        ResponseMessage responseMessage = accountService.registerUser(name, password, email);
        return responseMessage;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET, params = {"email","password"})
    public ResponseMessage signIn(@RequestParam("email") String email,
                                    @RequestParam("password") String password ){

        ResponseMessage responseMessage = accountService.loginUser(email, password);
        return responseMessage;
    }

    @RequestMapping(value = "/change", method = RequestMethod.GET, params = {"email", "oldPassword","newPassword"})
    public ResponseMessage changePassword(@RequestParam("email") String email,
                                    @RequestParam("oldPassword") String oldPassword,
                                    @RequestParam("newPassword") String newPassword) {

        ResponseMessage responseMessage = accountService.changePassword(email, oldPassword, newPassword);
        return responseMessage;
    }



}
