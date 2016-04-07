package com.kuzmen.recipes.restservice.entity;


import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class RecipeIngredientId implements Serializable {

    private Recipe recipe;
    private Ingredient ingredient;


    @ManyToOne
    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @ManyToOne
    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeIngredientId)) return false;

        RecipeIngredientId that = (RecipeIngredientId) o;

        if (getRecipe() != null ? !getRecipe().equals(that.getRecipe()) : that.getRecipe() != null) return false;
        return !(getIngredient() != null ? !getIngredient().equals(that.getIngredient()) : that.getIngredient() != null);

    }

    @Override
    public int hashCode() {
        int result = getRecipe() != null ? getRecipe().hashCode() : 0;
        result = 31 * result + (getIngredient() != null ? getIngredient().hashCode() : 0);
        return result;
    }
}