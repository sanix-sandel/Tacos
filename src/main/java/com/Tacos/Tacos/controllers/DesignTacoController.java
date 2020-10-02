package com.Tacos.Tacos.controllers;

import com.Tacos.Tacos.models.Order;
import com.Tacos.Tacos.models.Taco;
import com.Tacos.Tacos.data.IngredientRepository;
import com.Tacos.Tacos.data.TacoRepository;
import com.Tacos.Tacos.models.Ingredient;
import com.Tacos.Tacos.models.Type;
import com.Tacos.Tacos.services.IngredientService;
import com.Tacos.Tacos.services.TacoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientService ingredientService;

    private TacoService tacoService;

    public DesignTacoController(IngredientService ingredientService, TacoService tacoService) {
        this.ingredientService = ingredientService;
        this.tacoService = tacoService;
    }

    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientService.findAll().forEach(i->ingredients.add(i));

         Type[] types=Type.values();
         for(Type type:types){
            model.addAttribute(type.toString().toLowerCase(),
                    ingredientService.filterByType(ingredients, type));
         }

         return "design";
    }


    /*@PostMapping
    public String processDesign(@Valid Taco taco,
                                Errors errors,
                                @ModelAttribute Order order){

        if(errors.hasErrors()){
            return "design";
        }
        //log.info("Process design: "+design);
        Taco saved=tacoService.save(taco);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }*/
}
