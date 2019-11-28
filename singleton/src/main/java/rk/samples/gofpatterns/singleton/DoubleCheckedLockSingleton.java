package rk.samples.gofpatterns.singleton;

import java.util.Objects;

/**
 //Advantages: 1. work with multithreading
 //            2. lazy initialization
 //            3. can manage exceptions in constructor
 //Disadvantages: 1. can slow down performance because using violate modifier
 */
public class DoubleCheckedLockSingleton implements Singleton {
    private static volatile DoubleCheckedLockSingleton instance; //volatile keyword guarantees visibility of changes to variables across threads

    private DoubleCheckedLockSingleton() {
    }

    public static DoubleCheckedLockSingleton getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (DoubleCheckedLockSingleton.class) {
                if (Objects.isNull(instance)) {
                    instance = new DoubleCheckedLockSingleton();
                }
            }
        }
        return instance;
    }
}
