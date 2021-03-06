package rk.samples.gofpatterns.builder;

import lombok.extern.log4j.Log4j2;
import rk.samples.gofpatterns.builder.coffee.Barista;
import rk.samples.gofpatterns.builder.coffee.Coffee;
import rk.samples.gofpatterns.builder.coffee.builders.CoffeeBuilder;
import rk.samples.gofpatterns.builder.coffee.CoffeeType;
import rk.samples.gofpatterns.builder.coffee.builders.DefectiveCoffeeBuilder;
import rk.samples.gofpatterns.builder.coffee.exception.NotReadyOrWrongCoffeeException;
import rk.samples.gofpatterns.builder.coffee.recipe.CoffeeRecipe;
import rk.samples.gofpatterns.builder.simple.SimplePropertiesBuilder;
import rk.samples.gofpatterns.builder.simple.SomePropertiesHolder;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import static rk.samples.gofpatterns.builder.coffee.CoffeeType.AMERICANO;
import static rk.samples.gofpatterns.builder.coffee.CoffeeType.CAPPUCHINO;
import static rk.samples.gofpatterns.builder.coffee.CoffeeType.ESPRESSO;
import static rk.samples.gofpatterns.builder.coffee.CoffeeType.IRISH;
import static rk.samples.gofpatterns.builder.coffee.CoffeeType.LATTE;
import static rk.samples.gofpatterns.builder.coffee.CoffeeType.LATTE_WITH_STRAWBERRY_SYRUP;
import static rk.samples.gofpatterns.builder.coffee.CoffeeType.LATTE_WITH_VANILLA_SYRUP;

@Log4j2
public class BuilderSample {

    public static void main(String[] args) {
        SomePropertiesHolder properties = SimplePropertiesBuilder.createProperties()
                .setLongProperty(100)
                .setStringProperty("sample")
                .setDoubleProperty(3.14)
                .setListProperty(new ArrayList<>())
                .setMapProperty(new HashMap<>())
                .getResult();

        log.info(properties);


        Barista barista = new Barista();

        Map<CoffeeType, CoffeeRecipe> recipes = new EnumMap<>(CoffeeType.class);
        recipes.put(ESPRESSO, Barista.getEspressoRecipe());
        recipes.put(AMERICANO, Barista.getAmericanoRecipe());
        recipes.put(CAPPUCHINO, Barista.getCappuchinoRecipe());
        recipes.put(LATTE, Barista.getLatteRecipe());
        recipes.put(LATTE_WITH_STRAWBERRY_SYRUP, Barista.getLatteWithStrawberrySyrup());
        recipes.put(LATTE_WITH_VANILLA_SYRUP, Barista.getLatteWithVanillaSyrup());
        recipes.put(IRISH, Barista.getIrishCoffeeRecipe());

        log.trace("We have got the following recipes:");
        recipes.forEach((k, v) -> log.trace(v));

        CoffeeBuilder coffeeBuilder = new CoffeeBuilder();
        log.trace("Try to make coffee with {}.", coffeeBuilder);
        makeAllCaffeeByBuilder(coffeeBuilder, recipes, barista);


        CoffeeBuilder defectiveCoffeeBuilder = new DefectiveCoffeeBuilder();
        log.trace("Try to make coffee with {}.", defectiveCoffeeBuilder);
        makeAllCaffeeByBuilder(defectiveCoffeeBuilder, recipes, barista);


    }

    private static void makeAllCaffeeByBuilder(CoffeeBuilder coffeeBuilder, Map<CoffeeType, CoffeeRecipe> recipes, Barista barista) {
        recipes.forEach((k, v) -> {
            log.trace("Make me {} please.", k.getTypeName());
            Coffee coffee = barista.makeCoffee(k, coffeeBuilder);
            if (!v.validate(coffee.getComposition())) {
                log.error(new NotReadyOrWrongCoffeeException(k).getMessage());
            } else {
                log.info(coffee);
                log.trace("{} is ready!", k.getTypeName());
            }
        });
    }



}
