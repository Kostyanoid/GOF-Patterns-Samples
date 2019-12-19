package rk.samples.gofpatterns.builder.coffee;

import lombok.Getter;

@Getter
public enum CoffeeType {
    ESPRESSO("Espresso"),
    AMERICANO("Americano"),
    CAPPUCHINO("Cappuchino"),
    LATTE("Latte"),
    LATTE_WITH_STRAWBERRY_SYRUP("Latte with strawbery syrup"),
    LATTE_WITH_VANILLA_SYRUP("Latte with vanilla syrup"),
    IRISH("Irish coffee");

    private String typeName;

    CoffeeType(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }
}
