package com.kuzmen.recipes.restservice.service;


import com.kuzmen.recipes.restservice.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAll();
    List<Comment> findByRecipe(int id);

}
