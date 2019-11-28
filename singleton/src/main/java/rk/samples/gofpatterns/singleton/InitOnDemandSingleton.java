package rk.samples.gofpatterns.singleton;

/**
//Advantages: 1. work with multithreading
//            2. lazy initialization
//Disadvantages: 1. can't manage exceptions in constructor
*/
public class InitOnDemandSingleton implements Singleton {
    private static class InstanceHolder {
        private static final InitOnDemandSingleton INSTANCE = new InitOnDemandSingleton();
    }

    private InitOnDemandSingleton() {
    }

    public static InitOnDemandSingleton getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
