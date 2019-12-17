package rk.samples.gofpatterns.builder.coffee.exception;

import rk.samples.gofpatterns.builder.coffee.CoffeeType;

public class NotReadyOrWrongCoffeeException extends RuntimeException {
    public NotReadyOrWrongCoffeeException(CoffeeType coffeeType) {
        super(coffeeType.toString() + " is not ready or wrong.");
    }
}
