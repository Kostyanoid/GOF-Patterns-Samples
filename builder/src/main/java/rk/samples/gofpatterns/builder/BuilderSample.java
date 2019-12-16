package rk.samples.gofpatterns.builder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

public class BuilderSample {

    private final static Logger logger = LogManager.getLogger(BuilderSample.class);

    public static void main(String[] args) {
        SomePropertiesHolder properties = SimplePropertiesBuilder.createProperties()
                .setLongProperty(100)
                .setStringProperty("sample")
                .setDoubleProperty(3.14)
                .setListProperty(new ArrayList<>())
                .setMapProperty(new HashMap<>())
                .getResult();

        logger.info(properties);
    }



}
