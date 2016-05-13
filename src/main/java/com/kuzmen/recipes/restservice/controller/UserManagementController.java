package com.kuzmen.recipes.restservice.controller;

import com.kuzmen.recipes.restservice.entity.Comment;
import com.kuzmen.recipes.restservice.entity.Recipe;
import com.kuzmen.recipes.restservice.entity.User;
import com.kuzmen.recipes.restservice.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping(value = "/user")
@RestController
public class UserManagementController {
    @Autowired
    UserManagementService userManagementService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getHello() {
        return userManagementService.getAll();
    }

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Set<Comment> getComments(@PathVariable("id") int id){
        return userManagementService.getCommentsByUser(id);
    }
}
