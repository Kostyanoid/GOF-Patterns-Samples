package rk.samples.gofpatterns.builder.coffee.builders;

import rk.samples.gofpatterns.builder.coffee.Coffee;
import rk.samples.gofpatterns.builder.coffee.CoffeeType;
import rk.samples.gofpatterns.builder.coffee.ingredient.Syrup;
import rk.samples.gofpatterns.builder.coffee.ingredient.Ingredient;

public class CoffeeBuilder implements CoffeeAndRecipeBuilder {
    protected Coffee coffee;

    @Override
    public CoffeeBuilder reset() {
        coffee = new Coffee();
        return this;
    }

    @Override
    public CoffeeBuilder addEspresso() {
        coffee.addIngredient(new Ingredient("Espresso", SMALL_AMOUNT));
        return this;
    }

    @Override
    public CoffeeBuilder addHotWater() {
        coffee.addIngredient(new Ingredient("Hot watter", MIDDLE_AMOUNT));
        return this;
    }

    @Override
    public CoffeeBuilder addMilkFoam() {
        coffee.addIngredient(new Ingredient("Milk foam", MIDDLE_AMOUNT));
        return this;
    }

    @Override
    public CoffeeBuilder addSyrup(Syrup syrup) {
        coffee.addIngredient(new Ingredient(syrup.getTaste(), SYRUP_AMOUNT));
        return this;
    }

    @Override
    public CoffeeBuilder addWhisky() {
        coffee.addIngredient(new Ingredient("Whisky", WHISKY_AMOUNT));
        return this;
    }

    public CoffeeBuilder setType(CoffeeType type) {
        coffee.setCoffeeType(type);
        return this;
    }

    public Coffee getCoffee() {
        coffee.makeReady();
        return coffee;
    }
}
