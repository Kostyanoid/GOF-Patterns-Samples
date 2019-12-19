package rk.samples.gofpatterns.builder.coffee;

import rk.samples.gofpatterns.builder.coffee.builders.CoffeeBuilder;
import rk.samples.gofpatterns.builder.coffee.ingredient.StrawberrySyrup;
import rk.samples.gofpatterns.builder.coffee.ingredient.VanillaSyrop;
import rk.samples.gofpatterns.builder.coffee.recipe.CoffeeRecipe;
import rk.samples.gofpatterns.builder.coffee.builders.RecipeBuilder;

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
                coffeeBuilder.setType(AMERICANO);
                coffeeBuilder.addEspresso();
                coffeeBuilder.addHotWater();
                break;
            case CAPPUCHINO:
                coffeeBuilder.setType(CAPPUCHINO);
                coffeeBuilder.addEspresso();
                coffeeBuilder.addMilkFoam();
                break;
            case LATTE:
                coffeeBuilder.setType(LATTE);
                coffeeBuilder.addMilkFoam();
                coffeeBuilder.addEspresso();
                break;
            case LATTE_WITH_VANILLA_SYRUP:
                coffeeBuilder.setType(LATTE_WITH_VANILLA_SYRUP);
                coffeeBuilder.addMilkFoam();
                coffeeBuilder.addEspresso();
                coffeeBuilder.addSyrup(new VanillaSyrop());
                break;
            case LATTE_WITH_STRAWBERRY_SYRUP:
                coffeeBuilder.setType(LATTE_WITH_STRAWBERRY_SYRUP);
                coffeeBuilder.addMilkFoam();
                coffeeBuilder.addEspresso();
                coffeeBuilder.addSyrup(new StrawberrySyrup());
                break;
            case IRISH:
                coffeeBuilder.setType(IRISH);
                coffeeBuilder.addEspresso();
                coffeeBuilder.addWhisky();
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
                .addHotWater()
                .getRecipe();
    }

    public static CoffeeRecipe getCappuchinoRecipe() {
        return new RecipeBuilder()
                .setType(CAPPUCHINO)
                .addEspresso()
                .addMilkFoam()
                .getRecipe();
    }

    public static CoffeeRecipe getLatteRecipe() {
        return new RecipeBuilder()
                .setType(LATTE)
                .addMilkFoam()
                .addEspresso()
                .getRecipe();
    }

    public static CoffeeRecipe getLatteWithStrawberrySyrup() {
        return new RecipeBuilder()
                .setType(LATTE_WITH_STRAWBERRY_SYRUP)
                .addMilkFoam()
                .addEspresso()
                .addSyrup(new StrawberrySyrup())
                .getRecipe();
    }

    public static CoffeeRecipe getLatteWithVanillaSyrup() {
        return new RecipeBuilder()
                .setType(LATTE_WITH_VANILLA_SYRUP)
                .addMilkFoam()
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
