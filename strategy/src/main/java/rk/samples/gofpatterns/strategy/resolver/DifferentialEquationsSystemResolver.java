package rk.samples.gofpatterns.strategy.resolver;

import rk.samples.gofpatterns.strategy.methods.DifferentialEquationsSystemSolvingMethod;
import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystem;
import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystemSolution;
import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystemSolvingParameters;

public class DifferentialEquationsSystemResolver {
    private DifferentialEquationsSystem equationsSystem;
    private DifferentialEquationsSystemSolvingMethod method;
    private double accuracy;
    private double xStart;
    private double xEnd;
    private double[] y0;
    private double step;

    public DifferentialEquationsSystemResolver() {
        this.xStart = 0;
        this.step = 1;
    }

    public DifferentialEquationsSystemResolver(DifferentialEquationsSystem equationsSystem, double accuracy) {
        this();
        this.equationsSystem = equationsSystem;
        this.y0 = new double[equationsSystem.getDimension()];
        this.accuracy = accuracy;
    }

    public DifferentialEquationsSystemSolution solve() {
        DifferentialEquationsSystemSolvingParameters parameters = new DifferentialEquationsSystemSolvingParameters();
        parameters.setAccuracy(accuracy);
        parameters.setStep(step);
        parameters.setxStart(xStart);
        parameters.setxEnd(xEnd);
        parameters.setY0(y0);
        return method.solve(equationsSystem, parameters);
    }

    public void setEquationsSystem(DifferentialEquationsSystem equationsSystem) {
        this.equationsSystem = equationsSystem;
    }

    public void setMethod(DifferentialEquationsSystemSolvingMethod method) {
        this.method = method;
    }

    public void setInterval(double xStart, double xEnd) {
        this.xStart = xStart;
        this.xEnd = xEnd;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public DifferentialEquationsSystem getEquationsSystem() {
        return equationsSystem;
    }

    public DifferentialEquationsSystemSolvingMethod getMethod() {
        return method;
    }

    public double getXStart() {
        return xStart;
    }

    public double getXEnd() {
        return xEnd;
    }

    public double[] getY0() {
        return y0;
    }

    public double getStep() {
        return step;
    }

    public void setXStart(double xStart) {
        this.xStart = xStart;
    }

    public void setXEnd(double xEnd) {
        this.xEnd = xEnd;
    }

    public void setY0(double[] y0) {
        this.y0 = y0;
    }

    public void setStep(double step) {
        this.step = step;
    }
}
