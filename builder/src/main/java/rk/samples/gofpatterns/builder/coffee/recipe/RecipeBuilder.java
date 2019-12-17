package rk.samples.gofpatterns.builder.coffee.recipe;

import rk.samples.gofpatterns.builder.coffee.CoffeeAndRecipeBuilder;
import rk.samples.gofpatterns.builder.coffee.CoffeeType;
import rk.samples.gofpatterns.builder.coffee.ingredient.Ingredient;
import rk.samples.gofpatterns.builder.coffee.ingredient.Syrup;

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
        recipe.addIngredient(new Ingredient("Espresso", 50));
        return this;
    }

    @Override
    public RecipeBuilder addHotWater(Integer amount) {
        recipe.addIngredient(new Ingredient("Hot watter", 100));
        return this;
    }

    @Override
    public RecipeBuilder addMilkFoam(Integer amount) {
        recipe.addIngredient(new Ingredient("Milk foam", 100));
        return this;
    }

    @Override
    public RecipeBuilder addSyrup(Syrup syrup) {
        recipe.addIngredient(new Ingredient(syrup.getTaste(), 20));
        return this;
    }

    @Override
    public RecipeBuilder addWhisky() {
        recipe.addIngredient(new Ingredient("Whisky", 30));
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
