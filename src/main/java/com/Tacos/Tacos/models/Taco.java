package com.Tacos.Tacos.models;

import com.Tacos.Tacos.models.Ingredient;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class  Taco {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Date createdAt;

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;


    @Size(min=1,message="You must choose at least 1 ingredient")
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Ingredient> ingredients=new ArrayList<>();

    public Taco() {
    }

    public Taco(@NotNull @Size(min = 5, message = "Name must be at least 5 characters long") String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

}
