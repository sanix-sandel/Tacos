package com.Tacos.Tacos.services;

import com.Tacos.Tacos.data.IngredientRepository;
import com.Tacos.Tacos.models.Ingredient;
import com.Tacos.Tacos.models.Type;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService{

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findAll(){
        List<Ingredient> ingredients=new ArrayList<>();
        ingredientRepository.findAll().iterator().forEachRemaining(ingredients::add);
        return ingredients;
    }

    @Override
    public List<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
        return this.findAll()
                .stream()
                .filter(x->x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public Ingredient findById(Long id){
        Optional<Ingredient> ingredientOptional=ingredientRepository.findById(id);
        Ingredient ingredient=ingredientOptional.get();
        return ingredient;
    }
}
