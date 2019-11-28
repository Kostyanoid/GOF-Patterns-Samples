package rk.samples.gofpatterns.singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

public class SingletonSample {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        try {
            trySingletonClass(DoubleCheckedLockSingleton.class);
            trySingletonClass(EarlyInitSingleton.class);
            trySingletonClass(InitOnDemandSingleton.class);
            trySingletonClass(EnumSingleton.class);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    private static void trySingletonClass(Class<? extends Singleton> singletonClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Singleton s1 = (Singleton) singletonClass.getMethod("getInstance").invoke(null);
        Singleton s2 = (Singleton) singletonClass.getMethod("getInstance").invoke(null);

        s1.sayHello();
        s2.sayHello();
        logger.info("first: {} == second: {}", s1, s1);
    }
}
