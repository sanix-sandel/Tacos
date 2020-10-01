package com.Tacos.Tacos.services;

import com.Tacos.Tacos.models.Ingredient;
import com.Tacos.Tacos.models.Type;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findAll();
    List<Ingredient> filterByType(List<Ingredient> ingredients, Type type);
    Ingredient findById(Long id);
}
