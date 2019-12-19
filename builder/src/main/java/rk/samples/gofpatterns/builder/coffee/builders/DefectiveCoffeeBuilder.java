package rk.samples.gofpatterns.builder.coffee.builders;

import rk.samples.gofpatterns.builder.coffee.ingredient.Ingredient;

public class DefectiveCoffeeBuilder extends CoffeeBuilder {

    @Override
    public CoffeeBuilder addMilkFoam() {
        coffee.addIngredient(new Ingredient("Milk foam", MIDDLE_AMOUNT + 20));
        return this;
    }
}
