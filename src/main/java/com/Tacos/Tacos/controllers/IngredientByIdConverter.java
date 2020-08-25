package com.Tacos.Tacos.controllers;

import com.Tacos.Tacos.data.IngredientRepository;
import com.Tacos.Tacos.models.Ingredient;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private IngredientRepository ingredientRepo;


    public IngredientByIdConverter(IngredientRepository ingredientRepo){
        this.ingredientRepo=ingredientRepo;
    }

    @Override
    public Ingredient convert(String id){
        return ingredientRepo.findById(id);
    }
}
