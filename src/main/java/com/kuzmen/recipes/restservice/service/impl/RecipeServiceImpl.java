package com.kuzmen.recipes.restservice.service.impl;

import com.kuzmen.recipes.restservice.entity.Recipe;
import com.kuzmen.recipes.restservice.repository.RecipeRepository;
import com.kuzmen.recipes.restservice.service.AccountService;
import com.kuzmen.recipes.restservice.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    RecipeRepository recipeRepository;

    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }
}


