package com.kuzmen.recipes.restservice.service;


import com.kuzmen.recipes.restservice.entity.Comment;
import com.kuzmen.recipes.restservice.entity.User;

import java.util.List;
import java.util.Set;

public interface UserManagementService {
    List<User>  getAll();
    User getByEmail(String email);
    Set<Comment> getCommentsByUser(int id);
}
