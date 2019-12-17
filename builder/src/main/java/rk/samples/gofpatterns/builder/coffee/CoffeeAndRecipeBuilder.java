package rk.samples.gofpatterns.builder.coffee;

import rk.samples.gofpatterns.builder.coffee.ingredient.Syrup;

public interface CoffeeAndRecipeBuilder {
    CoffeeAndRecipeBuilder reset();
    CoffeeAndRecipeBuilder addEspresso();
    CoffeeAndRecipeBuilder addHotWater(Integer amount);
    CoffeeAndRecipeBuilder addMilkFoam(Integer amount);
    CoffeeAndRecipeBuilder addSyrup(Syrup syrup);
    CoffeeAndRecipeBuilder addWhisky();
}
