package rk.samples.gofpatterns.visitor.visitors;

import rk.samples.gofpatterns.visitor.model.Circle;
import rk.samples.gofpatterns.visitor.model.Rectangle;
import rk.samples.gofpatterns.visitor.model.Triangle;

public interface ShapeVisitor {
    double visit(Circle circle);
    double visit(Rectangle rectangle);
    double visit(Triangle triangle);
}
