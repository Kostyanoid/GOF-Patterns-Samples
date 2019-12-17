package rk.samples.gofpatterns.builder.simple;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class SomePropertiesHolder implements Serializable {

    private Integer integerProperty;

    private String stringProperty;

    private Double doubleProperty;

    private List<String> listProperty;

    private Map<Long, String> mapProperty;
}
