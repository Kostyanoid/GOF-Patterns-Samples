package rk.samples.gofpatterns.builder.coffee.builders;

import rk.samples.gofpatterns.builder.coffee.CoffeeType;
import rk.samples.gofpatterns.builder.coffee.ingredient.Ingredient;
import rk.samples.gofpatterns.builder.coffee.ingredient.Syrup;
import rk.samples.gofpatterns.builder.coffee.recipe.CoffeeRecipe;

public class RecipeBuilder implements CoffeeAndRecipeBuilder {
    private CoffeeRecipe recipe;

    public RecipeBuilder() {
        this.recipe = new CoffeeRecipe();
    }

    @Override
    public RecipeBuilder reset() {
        recipe = new CoffeeRecipe();
        return this;
    }

    @Override
    public RecipeBuilder addEspresso() {
        recipe.addIngredient(new Ingredient("Espresso", SMALL_AMOUNT));
        return this;
    }

    @Override
    public RecipeBuilder addHotWater() {
        recipe.addIngredient(new Ingredient("Hot watter", MIDDLE_AMOUNT));
        return this;
    }

    @Override
    public RecipeBuilder addMilkFoam() {
        recipe.addIngredient(new Ingredient("Milk foam", MIDDLE_AMOUNT));
        return this;
    }

    @Override
    public RecipeBuilder addSyrup(Syrup syrup) {
        recipe.addIngredient(new Ingredient(syrup.getTaste(), SYRUP_AMOUNT));
        return this;
    }

    @Override
    public RecipeBuilder addWhisky() {
        recipe.addIngredient(new Ingredient("Whisky", WHISKY_AMOUNT));
        return this;
    }

    public RecipeBuilder setType(CoffeeType type) {
        recipe.setCoffeeType(type);
        return this;
    }

    public CoffeeRecipe getRecipe() {
        return recipe;
    }
}
