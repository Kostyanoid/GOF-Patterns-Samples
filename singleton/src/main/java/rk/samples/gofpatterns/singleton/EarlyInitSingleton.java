package rk.samples.gofpatterns.singleton;

/**
//Advantages: work with multithreading
//Disadvantages: 1. not lazy initialization
//               2. can't manage exceptions in constructor
 */
public class EarlyInitSingleton implements Singleton {
    private static final EarlyInitSingleton INSTANCE = new EarlyInitSingleton();

    private EarlyInitSingleton() {

    }

    public static EarlyInitSingleton getInstance() {
        return INSTANCE;
    }
}
