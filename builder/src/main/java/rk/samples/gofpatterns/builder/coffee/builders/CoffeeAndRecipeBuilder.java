package rk.samples.gofpatterns.builder.coffee.builders;

import rk.samples.gofpatterns.builder.coffee.ingredient.Syrup;

public interface CoffeeAndRecipeBuilder {
    Integer SMALL_AMOUNT = 50;
    Integer MIDDLE_AMOUNT = 100;
    Integer SYRUP_AMOUNT = 20;
    Integer WHISKY_AMOUNT = 30;

    CoffeeAndRecipeBuilder reset();
    CoffeeAndRecipeBuilder addEspresso();
    CoffeeAndRecipeBuilder addHotWater();
    CoffeeAndRecipeBuilder addMilkFoam();
    CoffeeAndRecipeBuilder addSyrup(Syrup syrup);
    CoffeeAndRecipeBuilder addWhisky();
}
