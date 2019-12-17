package rk.samples.gofpatterns.builder.coffee;

import rk.samples.gofpatterns.builder.coffee.ingredient.Syrup;
import rk.samples.gofpatterns.builder.coffee.ingredient.Ingredient;

public class CoffeeBuilder implements CoffeeAndRecipeBuilder {
    private Coffee coffee;

    @Override
    public CoffeeBuilder reset() {
        coffee = new Coffee();
        return this;
    }

    @Override
    public CoffeeBuilder addEspresso() {
        coffee.addIngredient(new Ingredient("Espresso", 50));
        return this;
    }

    @Override
    public CoffeeBuilder addHotWater(Integer amount) {
        coffee.addIngredient(new Ingredient("Hot watter", 100));
        return this;
    }

    @Override
    public CoffeeBuilder addMilkFoam(Integer amount) {
        coffee.addIngredient(new Ingredient("Milk foam", 100));
        return this;
    }

    @Override
    public CoffeeBuilder addSyrup(Syrup syrup) {
        coffee.addIngredient(new Ingredient(syrup.getTaste(), 20));
        return this;
    }

    @Override
    public CoffeeBuilder addWhisky() {
        coffee.addIngredient(new Ingredient("Whisky", 30));
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
