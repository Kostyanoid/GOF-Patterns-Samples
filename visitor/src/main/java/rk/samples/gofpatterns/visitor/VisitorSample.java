package rk.samples.gofpatterns.visitor;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rk.samples.gofpatterns.visitor.model.Circle;
import rk.samples.gofpatterns.visitor.model.Point;
import rk.samples.gofpatterns.visitor.model.Rectangle;
import rk.samples.gofpatterns.visitor.model.Shape;
import rk.samples.gofpatterns.visitor.model.Triangle;

import java.util.ArrayList;
import java.util.List;

public class VisitorSample {
    private static final Logger logger = LogManager.getLogger(VisitorSample.class);

    public static void main(String[] args) {
        Shape circle = new Circle(1, 1,1);
        Shape rectangle = new Rectangle(new Point(0, 0), new Point(3, 4));
        Shape triangle = new Triangle(0, 0, 0, 2, 2, 0);

        List<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(triangle);

        shapes.forEach(shape -> logger.info(shape.toString()));
    }

}
