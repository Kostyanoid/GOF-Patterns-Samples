package rk.samples.gofpatterns.visitor.visitors;

import rk.samples.gofpatterns.visitor.model.Circle;
import rk.samples.gofpatterns.visitor.model.Rectangle;
import rk.samples.gofpatterns.visitor.model.Triangle;

public class AreaCalculatorShapeVisitor extends AbstractShapeVisitor {

    @Override
    public double visit(Circle circle) {
        int radius = circle.getRadius();
        return PI * radius * radius;
    }

    @Override
    public double visit(Rectangle rectangle) {
        int width = Math.abs(rectangle.getTopLeftX() - rectangle.getBottomRightX());
        int height = Math.abs(rectangle.getTopLeftY() - rectangle.getBottomRightY());
        return 1.0 * width * height;
    }

    @Override
    public double visit(Triangle triangle) {
        double firstSideLength = sideLength(triangle.getVertexOne(), triangle.getVertexTwo());
        double secondSideLength = sideLength(triangle.getVertexOne(), triangle.getVertexThree());
        double thirdSideLength = sideLength(triangle.getVertexTwo(), triangle.getVertexThree());
        double halfPerimeter = (firstSideLength + secondSideLength + thirdSideLength)/2.0;
        return Math.sqrt(halfPerimeter * (halfPerimeter - firstSideLength) * (halfPerimeter - secondSideLength) *(halfPerimeter - thirdSideLength));
    }
}
