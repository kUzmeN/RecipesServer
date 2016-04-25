package com.kuzmen.recipes.restservice.service;

import com.kuzmen.recipes.restservice.entity.Recipe;

import java.util.List;


public interface RecipeService {
    List<Recipe> readAll();

}
