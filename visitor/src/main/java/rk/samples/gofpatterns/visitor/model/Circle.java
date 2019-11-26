package rk.samples.gofpatterns.visitor.model;

import java.util.Objects;

public class Circle implements Shape {
    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Circle(int x, int y, int radius) {
        this.center = new Point(x, y);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getArea() {
        return areaCalculatorVisitor.visit(this);
    }

    public double getPerimeter() {
        return perimeterCalculatorVisitor.visit(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius &&
                Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }

    @Override
    public String toString() {
        return "Circle: " +
                "center = " + center +
                ", radius = " + radius +
                " [area = " + getArea() +
                ", perimeter = " + getPerimeter() +
                "]";
    }
}
