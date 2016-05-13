package com.kuzmen.recipes.restservice.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ingredient")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.ingredient")
    private Set<RecipeIngredient> recipeIngredients = new HashSet<RecipeIngredient>(0);

}
