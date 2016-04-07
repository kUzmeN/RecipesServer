package com.kuzmen.recipes.restservice.entity;


import javax.persistence.*;

@Entity
@Table(name = "recipe_ingredient")
@AssociationOverrides({
        @AssociationOverride(name = "pk.recipe",
                joinColumns = @JoinColumn(name = "recipe_id")),
        @AssociationOverride(name = "pk.ingredient",
                joinColumns = @JoinColumn(name = "ingredient_id"))})

public class RecipeIngredient {


    private RecipeIngredientId pk = new RecipeIngredientId();
    @Column(name = "quantity", nullable = false, length = 10)
    private int quantity;
    @Column(name = "measure", nullable = false, length = 10)
    private String measure;

    public RecipeIngredient() {
    }

    @EmbeddedId
    public RecipeIngredientId getPk() {
        return pk;
    }

    public void setPk(RecipeIngredientId pk) {
        this.pk = pk;
    }

    @Transient
    public Recipe getRecipe() {
        return getPk().getRecipe();
    }

    public void setRecipe(Recipe recipe) {
        getPk().setRecipe(recipe);
    }

    @Transient
    public Ingredient getIngredient() {
        return getPk().getIngredient();
    }

    public void setIngredient(Ingredient ingredient) {
        getPk().setIngredient(ingredient);
    }



    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}