package rk.samples.gofpatterns.strategy.structures;

public class DifferentialEquationsSystemSolvingParameters {
    private double step;
    private double xStart;
    private double xEnd;
    private double[] y0;
    private double accuracy;

    public DifferentialEquationsSystemSolvingParameters() {
    }

    public DifferentialEquationsSystemSolvingParameters(double step, double xStart, double xEnd, double[] y0, double accuracy) {
        this.step = step;
        this.xStart = xStart;
        this.xEnd = xEnd;
        this.y0 = y0;
        this.accuracy = accuracy;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public double getXStart() {
        return xStart;
    }

    public void setXStart(double xStart) {
        this.xStart = xStart;
    }

    public double getXEnd() {
        return xEnd;
    }

    public void setYEnd(double xEnd) {
        this.xEnd = xEnd;
    }

    public void setInterval(double xStart, double xEnd) {
        this.xStart = xStart;
        this.xEnd = xEnd;
    }

    public double[] getY0() {
        return y0;
    }

    public void setY0(double[] y0) {
        this.y0 = y0;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }
}
