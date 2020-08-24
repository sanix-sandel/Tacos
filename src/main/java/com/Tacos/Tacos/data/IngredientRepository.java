package com.Tacos.Tacos.data;

import com.Tacos.Tacos.models.Ingredient;

public interface IngredientRepository {

    Iterable <Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);
}
