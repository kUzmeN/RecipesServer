package com.kuzmen.recipes.restservice.service;


import com.kuzmen.recipes.restservice.entity.User;

import java.util.List;

public interface UserManagementService {
    List<User>  getAll();
    User findByEmail(String email);
}
