package rk.samples.gofpatterns.builder;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SimplePropertiesBuilder {

    private SomePropertiesHolder properties;

    public static SimplePropertiesBuilder createProperties() {
        SimplePropertiesBuilder builder = new SimplePropertiesBuilder();
        builder.setProperties(new SomePropertiesHolder());
        return builder;
    }

    public SimplePropertiesBuilder setLongProperty(Integer integerValue) {
        this.properties.setIntegerProperty(integerValue);
        return this;
    }

    public SimplePropertiesBuilder setStringProperty(String stringValue) {
        this.properties.setStringProperty(stringValue);
        return this;
    }

    public SimplePropertiesBuilder setDoubleProperty(Double doubleProperty) {
        this.properties.setDoubleProperty(doubleProperty);
        return this;
    }

    @SuppressWarnings("unchecked")
    public SimplePropertiesBuilder setListProperty(List<String> listProperty) {
        List<String> copylist = null;
        if (listProperty != null) {
            try {
                copylist = listProperty.getClass().newInstance();
                if (!listProperty.isEmpty()) {
                    copylist.set(listProperty.size() - 1, "");
                    Collections.copy(copylist, listProperty);
                }
            } catch (IllegalAccessException | InstantiationException | ExceptionInInitializerError | SecurityException e) {
                copylist = listProperty;
            }
        }
        this.properties.setListProperty(copylist);
        return this;
    }

    @SuppressWarnings("unchecked")
    public SimplePropertiesBuilder setMapProperty(Map<Long, String> mapProperty) {
        Map<Long, String> copyMap;
        try {
            copyMap = mapProperty.getClass().newInstance();
            mapProperty.forEach(copyMap::put);
        } catch (IllegalAccessException | InstantiationException | ExceptionInInitializerError | SecurityException e) {
            copyMap = mapProperty;
        }
        this.properties.setMapProperty(copyMap);
        return this;
    }

    public SomePropertiesHolder getResult() {
        return this.properties;
    }


    private SomePropertiesHolder getProperties() {
        return this.properties;
    }

    private void setProperties(SomePropertiesHolder propertiesHolder) {
        this.properties = propertiesHolder;
    }
}
