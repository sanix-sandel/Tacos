package com.Tacos.Tacos.api;

import com.Tacos.Tacos.models.Ingredient;
import com.Tacos.Tacos.services.IngredientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientApi {

    private final IngredientService ingredientService;

    public IngredientApi(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<Ingredient> getIngredients(){
        List<Ingredient> ingredients=ingredientService.findAll();
        return ingredients;
    }
}
