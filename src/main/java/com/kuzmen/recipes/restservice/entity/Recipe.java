package com.kuzmen.recipes.restservice.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "recipe")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Recipe implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", unique = true, nullable = false)

    private int id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "image", nullable = false)
    private String image;
    @Column(name = "time", nullable = false)
    private int time;
    @Column(name = "likes", nullable = false)
    private int likes;
    @Column(name = "link", nullable = true)
    private String link;


    @Column(name = "updated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)

    private Category category;


    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
    private Set<Step> steps;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.recipe")
    private Set<RecipeIngredient> recipeIngredients = new HashSet<RecipeIngredient>(0);


    public Recipe() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }


    public Set<Step> getSteps() {

        return steps;
    }

    public void setSteps(Set<Step> steps) {
        this.steps = steps;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(Set<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }


}
