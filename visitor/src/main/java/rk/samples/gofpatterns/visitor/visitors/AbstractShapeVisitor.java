package rk.samples.gofpatterns.visitor.visitors;

import rk.samples.gofpatterns.visitor.model.Point;

public abstract class AbstractShapeVisitor implements ShapeVisitor {
    protected static final double PI = Math.PI;

    protected double sideLength(Point v1, Point v2) {
        double xLength = 1.0 * v1.getX() - v2.getX();
        double yLength = 1.0 * v1.getY() - v2.getY();
        return Math.sqrt(xLength*xLength + yLength*yLength);
    }
}
