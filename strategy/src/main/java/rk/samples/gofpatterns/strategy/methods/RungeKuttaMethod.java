package rk.samples.gofpatterns.strategy.methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rk.samples.gofpatterns.strategy.structures.Differential;
import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystem;
import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystemSolution;
import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystemSolvingParameters;

import java.util.List;

import static rk.samples.gofpatterns.strategy.utils.DecimalFormatter.formatXValue;
import static rk.samples.gofpatterns.strategy.utils.DecimalFormatter.formatYValue;
import static rk.samples.gofpatterns.strategy.utils.NumbersUtil.between;

public class RungeKuttaMethod implements DifferentialEquationsSystemSolvingMethod {
    private static final Logger logger = LogManager.getLogger(RungeKuttaMethod.class);

    private static final double[] METHOD_COEFFS = new double[]{1.0 / 6, 2.0 / 6, 2.0 / 6, 1.0 / 6};
    private static final String NAME = "4-order Runge-Kutta";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public DifferentialEquationsSystemSolution solve(DifferentialEquationsSystem equationsSystem, DifferentialEquationsSystemSolvingParameters parameters) {
        DifferentialEquationsSystemSolution solution = new DifferentialEquationsSystemSolution();
        double x = parameters.getXStart();
        double h = parameters.getStep();
        int dimension = equationsSystem.getDimension();
        double[] y0 = new double[dimension];
        System.arraycopy(parameters.getY0(), 0, y0, 0, dimension);
        solution.addSolution(x, y0);
        int stepNumber = 0;
        double[] methodCoeffsWithStep = multipleVectorByNumber(METHOD_COEFFS, h);

        logger.debug(NAME + " method started.");
        logger.trace("x0: {}, y0: {}, step: {}", formatXValue(x), formatYValue(y0), formatXValue(h));

        double[] y = new double[dimension];
        System.arraycopy(parameters.getY0(), 0, y, 0, dimension);

        while (between(x + h, parameters.getXStart(), parameters.getXEnd())) {
            double[] k_1 = calculateNextK(x, y, equationsSystem.getEquations(), 0, new double[dimension]);
            double[] k_2 = calculateNextK(x, y, equationsSystem.getEquations(), h / 2, k_1);
            double[] k_3 = calculateNextK(x, y, equationsSystem.getEquations(), h / 2, k_2);
            double[] k_4 = calculateNextK(x, y, equationsSystem.getEquations(), h, k_3);
            double[] nextY = addVectors(y, linearCombination(methodCoeffsWithStep, k_1, k_2, k_3, k_4));

            x = x + h;
            solution.addSolution(x, nextY);
            System.arraycopy(nextY, 0, y, 0, dimension);
            stepNumber++;

            logger.trace("{}: x = {}, y = {}", stepNumber, formatXValue(x), formatYValue(y));
        }
        logger.debug(NAME + " method finished");

        return solution;
    }

    private double[] calculateNextK(double x, double[] y, List<Differential> equations, double step, double[] prevK) {
        double[] coeffs = new double[]{1.0, step};
        return equations.stream().mapToDouble(eq -> eq.calculate(x + step, linearCombination(coeffs, y, prevK))).toArray();
    }


    private double[] linearCombination(double[] coeffs, double[]... vectors) {
        double[][] modifiedVectors = new double[vectors.length][vectors[0].length];
        for (int i = 0; i < vectors.length; i++) {
            modifiedVectors[i] = multipleVectorByNumber(vectors[i], coeffs[i]);
        }
        return addVectors(modifiedVectors);
    }

    private double[] addVectors(double[]... vectors) {
        double[] result = new double[vectors[0].length];
        for (int i = 0; i < vectors[0].length; i++) {
            double sum = 0;
            for (double[] vector : vectors) {
                sum += vector[i];
            }
            result[i] = sum;
        }
        return result;
    }

    private double[] multipleVectorByNumber(double[] v, double number) {
        double[] result = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            result[i] = v[i] * number;
        }
        return result;
    }
}
