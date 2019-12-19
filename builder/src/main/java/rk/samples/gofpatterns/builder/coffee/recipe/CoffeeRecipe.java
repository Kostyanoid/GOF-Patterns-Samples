package rk.samples.gofpatterns.builder.coffee.recipe;

import lombok.Getter;
import lombok.Setter;
import rk.samples.gofpatterns.builder.coffee.CoffeeType;
import rk.samples.gofpatterns.builder.coffee.ingredient.Ingredient;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Getter
@Setter
public class CoffeeRecipe {
    private final List<Ingredient> recipe;
    private CoffeeType coffeeType;

    public CoffeeRecipe() {
        this.recipe = new LinkedList<>();
    }

    public CoffeeRecipe(List<Ingredient> newRecipe) {
        this();
        if (isNotNullOrEmptyComposition(newRecipe)) {
            this.recipe.addAll(newRecipe);
        }
    }

    public void addIngredient(Ingredient ingredient) {
        recipe.add(ingredient);
    }

    public Optional<Ingredient> getIngredient(int index) {
        if (index < 0 || index > recipe.size() - 1) {
            return Optional.empty();
        }
        return Optional.ofNullable(recipe.get(index));
    }

    public boolean validate(List<Ingredient> composition) {
        if (composition.size() < recipe.size()) {
            return false;
        }
        for (int i = 0; i < recipe.size(); i++) {
            if (!recipe.get(i).equals(composition.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isNotNullOrEmptyComposition(List<Ingredient> composition) {
        return Objects.nonNull(composition) && !composition.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(coffeeType).append(": ").append("\n");
        for (int i = 0; i < recipe.size(); i++) {
            builder.append("\t").append(i+1).append(") ").append(recipe.get(i).getName())
                    .append(" - ").append(recipe.get(i).getAmount()).append("\n");
        }
        return builder.toString();
    }
}
