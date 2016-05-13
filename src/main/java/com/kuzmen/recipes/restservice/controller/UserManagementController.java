package com.kuzmen.recipes.restservice.controller;

import com.kuzmen.recipes.restservice.entity.Recipe;
import com.kuzmen.recipes.restservice.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserManagementController {
    @Autowired
    UserManagementService userManagementService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<Recipe> getHello() {
        List users = userManagementService.getAll();

        return users;

    }
}
