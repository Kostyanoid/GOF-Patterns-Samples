package rk.samples.gofpatterns.visitor.visitors;

import rk.samples.gofpatterns.visitor.model.Circle;
import rk.samples.gofpatterns.visitor.model.Rectangle;
import rk.samples.gofpatterns.visitor.model.Triangle;

public class PerimeterCalculatorShapeVisitor extends AbstractShapeVisitor {
    @Override
    public double visit(Circle circle) {
        return PI * 2 * circle.getRadius();
    }

    @Override
    public double visit(Rectangle rectangle) {
        int width = Math.abs(rectangle.getTopLeftX() - rectangle.getBottomRightX());
        int height = Math.abs(rectangle.getTopLeftY() - rectangle.getBottomRightY());
        return 2.0 * (width + height);
    }

    @Override
    public double visit(Triangle triangle) {
        double firstSideLength = sideLength(triangle.getVertexOne(), triangle.getVertexTwo());
        double secondSideLength = sideLength(triangle.getVertexOne(), triangle.getVertexThree());
        double thirdSideLength = sideLength(triangle.getVertexTwo(), triangle.getVertexThree());
        return firstSideLength + secondSideLength +thirdSideLength;
    }
}
