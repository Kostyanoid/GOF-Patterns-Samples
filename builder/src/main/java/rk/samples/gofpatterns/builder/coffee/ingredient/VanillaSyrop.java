package rk.samples.gofpatterns.builder.coffee.ingredient;

public class VanillaSyrop extends Syrup {
    private static final String TASTE = "Vanilla syrup";

    @Override
    public String getTaste() {
        return TASTE;
    }
}
