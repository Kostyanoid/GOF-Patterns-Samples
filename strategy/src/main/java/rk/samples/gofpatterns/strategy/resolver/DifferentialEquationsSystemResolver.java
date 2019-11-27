package rk.samples.gofpatterns.strategy.resolver;

import rk.samples.gofpatterns.strategy.methods.DifferentialEquationsSystemSolvingMethod;
import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystem;
import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystemSolution;
import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystemSolvingParameters;

public class DifferentialEquationsSystemResolver {
    private DifferentialEquationsSystem equationsSystem;
    private DifferentialEquationsSystemSolvingMethod method;
    private DifferentialEquationsSystemSolvingParameters parameters;

    public DifferentialEquationsSystemResolver() {
        this.parameters = new DifferentialEquationsSystemSolvingParameters();
    }

    public DifferentialEquationsSystemResolver(DifferentialEquationsSystem equationsSystem) {
        this();
        this.equationsSystem = equationsSystem;
        this.parameters.setY0(new double[equationsSystem.getDimension()]);
    }

    public DifferentialEquationsSystemResolver(DifferentialEquationsSystem equationsSystem, DifferentialEquationsSystemSolvingParameters parameters) {
        this(equationsSystem);
        this.parameters = parameters;
    }

    public DifferentialEquationsSystemSolution solve() {
        return method.solve(equationsSystem, parameters);
    }

    public void setEquationsSystem(DifferentialEquationsSystem equationsSystem) {
        this.equationsSystem = equationsSystem;
    }

    public void setMethod(DifferentialEquationsSystemSolvingMethod method) {
        this.method = method;
    }

    public void setInterval(double xStart, double xEnd) {
        parameters.setXStart(xStart);
        parameters.setYEnd(xEnd);
    }

    public DifferentialEquationsSystem getEquationsSystem() {
        return equationsSystem;
    }

    public DifferentialEquationsSystemSolvingMethod getMethod() {
        return method;
    }

    public DifferentialEquationsSystemSolvingParameters getParameters() {
        return parameters;
    }

    public double getXStart() {
        return parameters.getXStart();
    }

    public double getXEnd() {
        return parameters.getXEnd();
    }

    public double[] getY0() {
        return parameters.getY0();
    }

    public double getStep() {
        return parameters.getStep();
    }

    public void setParameters(DifferentialEquationsSystemSolvingParameters parameters) {
        this.parameters = parameters;
    }

    public void setXStart(double xStart) {
        parameters.setXStart(xStart);
    }

    public void setXEnd(double xEnd) {
        parameters.setYEnd(xEnd);
    }

    public void setY0(double[] y0) {
        parameters.setY0(y0);
    }

    public void setStep(double step) {
        parameters.setStep(step);
    }
}
