package com.kuzmen.recipes.restservice.entity;


import javax.persistence.*;

@Entity
@Table(name = "recipe_ingredient")
@AssociationOverrides({
        @AssociationOverride(name = "pk.recipe",
                joinColumns = @JoinColumn(name = "recipe_id")),
        @AssociationOverride(name = "pk.ingredient",
                joinColumns = @JoinColumn(name = "ingredient_id"))})

@lombok.Setter
@lombok.NoArgsConstructor
@lombok.Getter
public class RecipeIngredient {


    private RecipeIngredientId pk = new RecipeIngredientId();
    @Column(name = "quantity", nullable = false, length = 10)
    private int quantity;
    @Column(name = "measure", nullable = false, length = 10)
    private String measure;


    @EmbeddedId
    public RecipeIngredientId getPk() {
        return pk;
    }

}