package rk.samples.gofpatterns.singleton;

public enum EnumSingleton implements Singleton {
    INSTANCE;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
