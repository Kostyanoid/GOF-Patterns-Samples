package rk.samples.gofpatterns.singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface Singleton {
    Logger logger = LogManager.getLogger("Singleton");

    default void sayHello() {
        logger.info("Hello! I am a " + this.getClass().getSimpleName() + " on @" + Integer.toHexString(this.hashCode()));
    }
}
