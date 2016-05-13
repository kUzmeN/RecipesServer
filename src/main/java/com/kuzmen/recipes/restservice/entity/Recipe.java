package com.kuzmen.recipes.restservice.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","sentMessages", "receivedMessages", "educationFacility"})
@JsonAutoDetect
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
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

    @OneToMany (fetch = FetchType.LAZY,mappedBy="recipe" ,cascade={CascadeType.DETACH})
    private Set<Comment> comments;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe" ,cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Step> steps;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.recipe",cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<RecipeIngredient> recipeIngredients = new HashSet<RecipeIngredient>(0);

}
