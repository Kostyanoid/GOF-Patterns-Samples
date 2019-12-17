package rk.samples.gofpatterns.builder.coffee;

import lombok.Getter;
import lombok.Setter;
import rk.samples.gofpatterns.builder.coffee.ingredient.Ingredient;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Coffee {
    @Getter
    private List<Ingredient> composition;

    @Getter
    @Setter
    private CoffeeType coffeeType;

    private boolean ready;

    public Coffee() {
        this.composition = new LinkedList<>();
        this.ready = false;
    }

    public void addIngredient(Ingredient ingredient) {
        composition.add(ingredient);
    }

    public Optional<Ingredient> getIngredient(int number) {
        if (number < 0 || number > composition.size() - 1) {
            return Optional.empty();
        }
        return Optional.ofNullable(composition.get(number));
    }

    public boolean isReady() {
        return ready;
    }

    public void makeReady() {
        this.ready = true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(coffeeType).append(": ").append("\n");
        composition.forEach(ingr -> builder.append("\t--").append(ingr).append("\n"));
        return builder.toString();
    }

}
