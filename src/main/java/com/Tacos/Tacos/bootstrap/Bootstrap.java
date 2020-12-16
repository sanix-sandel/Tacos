package com.Tacos.Tacos.bootstrap;

import com.Tacos.Tacos.data.IngredientRepository;
import com.Tacos.Tacos.data.TacoRepository;
import com.Tacos.Tacos.models.Ingredient;
import com.Tacos.Tacos.models.Taco;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.Tacos.Tacos.models.Type.*;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final IngredientRepository ingredientRepository;
    private final TacoRepository tacoRepository;

    public Bootstrap(IngredientRepository ingredientRepository,
    TacoRepository tacoRepository) {
        this.ingredientRepository = ingredientRepository;
        this.tacoRepository=tacoRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        ingredientRepository.saveAll(getIngredients());
        tacoRepository.saveAll(getTacos());

    }

    private List<Ingredient> getIngredients(){
        List <Ingredient> ingredients=new ArrayList<>();
        Ingredient ingredient1=new Ingredient();
        ingredient1.setName("Flour Tortilla");
        ingredient1.setType(WRAP);

        Ingredient ingredient2=new Ingredient();
        ingredient2.setName("Corn Tortilla");
        ingredient2.setType(WRAP);

        Ingredient ingredient3=new Ingredient();
        ingredient3.setName("Ground Beef");
        ingredient3.setType(PROTEIN);

        Ingredient ingredient4=new Ingredient();
        ingredient4.setName("Carnitas");
        ingredient4.setType(PROTEIN);

        Ingredient ingredient5=new Ingredient();
        ingredient5.setName("Diced Tomatoes");
        ingredient5.setType(VEGGIES);

        Ingredient ingredient6=new Ingredient();
        ingredient6.setName("Lettuce");
        ingredient6.setType(VEGGIES);

        Ingredient ingredient7=new Ingredient();
        ingredient7.setName("Cheddar");
        ingredient7.setType(CHEESE);

        Ingredient ingredient8=new Ingredient();
        ingredient8.setName("Monterrey Jack");
        ingredient8.setType(CHEESE);

        Ingredient ingredient9=new Ingredient();
        ingredient9.setName("Salsa");
        ingredient9.setType(SAUCE);

        Ingredient ingredient10=new Ingredient();
        ingredient10.setName("Sour Cream");
        ingredient10.setType(SAUCE);

        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        ingredients.add(ingredient3);
        ingredients.add(ingredient4);
        ingredients.add(ingredient5);
        ingredients.add(ingredient6);
        ingredients.add(ingredient7);
        ingredients.add(ingredient8);
        ingredients.add(ingredient9);
        ingredients.add(ingredient10);


        return ingredients;
    }

    private List<Taco> getTacos(){


        List<Taco> tacos=new ArrayList<>();

        Taco taco1=new Taco("Pizza");
        taco1.getIngredients().addAll(getIngredients().subList(0,4));

        Taco taco2=new Taco("Hamburger");
        taco2.getIngredients().addAll(getIngredients().subList(5, 8));

        tacos.add(taco1);
        tacos.add(taco2);
        return tacos;
    }
}
