package rk.samples.gofpatterns.visitor.model;

import java.util.Objects;

public class Triangle implements Shape {
    private Point vertexOne;
    private Point vertexTwo;
    private Point vertexThree;

    public Triangle(Point vertexOne, Point vertexTwo, Point vertexThree) {
        this.vertexOne = vertexOne;
        this.vertexTwo = vertexTwo;
        this.vertexThree = vertexThree;
    }

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.vertexOne = new Point(x1, y1);
        this.vertexTwo = new Point(x2, y2);
        this.vertexThree = new Point(x3, y3);
    }

    public Point getVertexOne() {
        return vertexOne;
    }

    public Point getVertexTwo() {
        return vertexTwo;
    }

    public Point getVertexThree() {
        return vertexThree;
    }

    public int vertexOneX() {
        return vertexOne.getX();
    }

    public int vertexOneY() {
        return vertexOne.getY();
    }

    public int vertexTwoX() {
        return vertexTwo.getX();
    }

    public int vertexTwoY() {
        return vertexTwo.getY();
    }

    public int vertexThreeX() {
        return vertexThree.getX();
    }

    public int vertexThreeY() {
        return vertexThree.getY();
    }

    @Override
    public double getArea() {
        return areaCalculatorVisitor.visit(this);
    }

    @Override
    public double getPerimeter() {
        return perimeterCalculatorVisitor.visit(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(vertexOne, triangle.vertexOne) &&
                Objects.equals(vertexTwo, triangle.vertexTwo) &&
                Objects.equals(vertexThree, triangle.vertexThree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexOne, vertexTwo, vertexThree);
    }

    @Override
    public String toString() {
        return "Triangle: " +
                "vertexOne = " + vertexOne +
                ", vertexTwo = " + vertexTwo +
                ", vertexThree = " + vertexThree +
                " [area = " + getArea() +
                ", perimeter = " + getPerimeter() +
                "]";
    }
}
