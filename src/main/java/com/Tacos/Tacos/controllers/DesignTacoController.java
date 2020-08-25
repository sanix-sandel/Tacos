package com.Tacos.Tacos.controllers;

import com.Tacos.Tacos.Order;
import com.Tacos.Tacos.Taco;
import com.Tacos.Tacos.data.IngredientRepository;
import com.Tacos.Tacos.data.TacoRepository;
import com.Tacos.Tacos.models.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    private TacoRepository designRepo;

    public DesignTacoController(IngredientRepository ingredientRepo,
                                TacoRepository designRepo) {
        this.ingredientRepo = ingredientRepo;
        this.designRepo=designRepo;
    }

    @ModelAttribute(name="order")
    public Order order(){
        return new Order();
    }

    @ModelAttribute(name="taco")
    public Taco taco(){
        return new Taco();
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
    public String processDesign(@Valid Taco design,
                                Errors errors,
                                @ModelAttribute Order order){

        if(errors.hasErrors()){
            return "design";
        }
        //log.info("Process design: "+design);
        Taco saved=designRepo.save(design);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }
}
