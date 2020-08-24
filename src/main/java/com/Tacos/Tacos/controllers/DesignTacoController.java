package com.Tacos.Tacos.controllers;

import com.Tacos.Tacos.Taco;
import com.Tacos.Tacos.data.IngredientRepository;
import com.Tacos.Tacos.models.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    public DesignTacoController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i->ingredients.add(i));

         Ingredient.Type[] types=Ingredient.Type.values();
         for(Ingredient.Type type:types){
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
         }

         return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient>ingredients, Ingredient.Type type){
        return ingredients.stream()
                .filter(x->x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors){

        if(errors.hasErrors()){
            return "design";
        }
        //log.info("Process design: "+design);
        return "redirect:/orders/current";
    }
}
