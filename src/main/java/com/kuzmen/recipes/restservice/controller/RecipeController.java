package com.kuzmen.recipes.restservice.controller;

import com.kuzmen.recipes.restservice.entity.Recipe;
import com.kuzmen.recipes.restservice.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {
    @Autowired
    RecipeService recipeService;


    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    @ResponseBody
    public List<Recipe> getHello() {
        List recipes = recipeService.readAll();

        return recipes;

    }

//    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public Recipe getHello(@PathVariable("id") int recipeId) {
//        return recipeService.readAll(recipeId);
//    }


}
