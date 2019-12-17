package rk.samples.gofpatterns.builder.coffee;

import rk.samples.gofpatterns.builder.coffee.ingredient.StrawberrySyrup;
import rk.samples.gofpatterns.builder.coffee.ingredient.VanillaSyrop;
import rk.samples.gofpatterns.builder.coffee.recipe.CoffeeRecipe;
import rk.samples.gofpatterns.builder.coffee.recipe.RecipeBuilder;

import static rk.samples.gofpatterns.builder.coffee.CoffeeType.AMERICANO;
import static rk.samples.gofpatterns.builder.coffee.CoffeeType.CAPPUCHINO;
import static rk.samples.gofpatterns.builder.coffee.CoffeeType.ESPRESSO;
import static rk.samples.gofpatterns.builder.coffee.CoffeeType.IRISH;
import static rk.samples.gofpatterns.builder.coffee.CoffeeType.LATTE;
import static rk.samples.gofpatterns.builder.coffee.CoffeeType.LATTE_WITH_STRAWBERRY_SYRUP;
import static rk.samples.gofpatterns.builder.coffee.CoffeeType.LATTE_WITH_VANILLA_SYRUP;

public class Barista {

    public Coffee makeCoffee(CoffeeType coffeeType, CoffeeBuilder coffeeBuilder) {
        coffeeBuilder.reset();
        switch (coffeeType) {
            case ESPRESSO:
                coffeeBuilder.setType(ESPRESSO);
                coffeeBuilder.addEspresso();
                break;
            case AMERICANO:
            case LATTE:
            case CAPPUCHINO:
            case LATTE_WITH_VANILLA_SYRUP:
            case LATTE_WITH_STRAWBERRY_SYRUP:
            case IRISH:
            default:
        }

        return coffeeBuilder.getCoffee();
    }

    public static CoffeeRecipe getEspressoRecipe() {
        return new RecipeBuilder()
                .setType(ESPRESSO)
                .addEspresso()
                .getRecipe();
    }

    public static CoffeeRecipe getAmericanoRecipe() {
        return new RecipeBuilder()
                .setType(AMERICANO)
                .addEspresso()
                .addHotWater(100)
                .getRecipe();
    }

    public static CoffeeRecipe getCappuchinoRecipe() {
        return new RecipeBuilder()
                .setType(CAPPUCHINO)
                .addEspresso()
                .addMilkFoam(100)
                .getRecipe();
    }

    public static CoffeeRecipe getLatteRecipe() {
        return new RecipeBuilder()
                .setType(LATTE)
                .addMilkFoam(100)
                .addEspresso()
                .getRecipe();
    }

    public static CoffeeRecipe getLatteWithStrawberrySyrup() {
        return new RecipeBuilder()
                .setType(LATTE_WITH_STRAWBERRY_SYRUP)
                .addMilkFoam(100)
                .addEspresso()
                .addSyrup(new StrawberrySyrup())
                .getRecipe();
    }

    public static CoffeeRecipe getLatteWithVanillaSyrup() {
        return new RecipeBuilder()
                .setType(LATTE_WITH_VANILLA_SYRUP)
                .addMilkFoam(100)
                .addEspresso()
                .addSyrup(new VanillaSyrop())
                .getRecipe();
    }

    public static CoffeeRecipe getIrishCoffeeRecipe() {
        return new RecipeBuilder()
                .setType(IRISH)
                .addEspresso()
                .addWhisky()
                .getRecipe();
    }
}
