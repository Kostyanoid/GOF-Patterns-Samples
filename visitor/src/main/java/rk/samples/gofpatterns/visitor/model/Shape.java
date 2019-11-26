package rk.samples.gofpatterns.visitor.model;

import rk.samples.gofpatterns.visitor.visitors.AreaCalculatorShapeVisitor;
import rk.samples.gofpatterns.visitor.visitors.PerimeterCalculatorShapeVisitor;
import rk.samples.gofpatterns.visitor.visitors.ShapeVisitor;

public interface Shape {
    ShapeVisitor areaCalculatorVisitor = new AreaCalculatorShapeVisitor();
    ShapeVisitor perimeterCalculatorVisitor = new PerimeterCalculatorShapeVisitor();

    double getArea();
    double getPerimeter();
}
