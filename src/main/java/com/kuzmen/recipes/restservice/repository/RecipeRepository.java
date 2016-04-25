package com.kuzmen.recipes.restservice.repository;


import com.kuzmen.recipes.restservice.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
