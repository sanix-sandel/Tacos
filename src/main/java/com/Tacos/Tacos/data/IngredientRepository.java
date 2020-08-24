package com.Tacos.Tacos.data;

import com.Tacos.Tacos.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
