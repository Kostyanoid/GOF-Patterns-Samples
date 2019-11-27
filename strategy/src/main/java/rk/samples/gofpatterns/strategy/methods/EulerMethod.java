package rk.samples.gofpatterns.strategy.methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystem;
import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystemSolution;
import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystemSolvingParameters;

import static rk.samples.gofpatterns.strategy.utils.DecimalFormatter.formatXValue;
import static rk.samples.gofpatterns.strategy.utils.DecimalFormatter.formatYValue;
import static rk.samples.gofpatterns.strategy.utils.NumbersUtil.between;

public class EulerMethod implements DifferentialEquationsSystemSolvingMethod {
    private static final Logger logger = LogManager.getLogger(EulerMethod.class);

    private static final String NAME = "Euler";

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

        logger.debug(NAME + " method started.");
        logger.trace("x0: {}, y0: {}, step: {}", formatXValue(x), formatYValue(y0), formatXValue(h));

        double[] y = new double[dimension];
        System.arraycopy(parameters.getY0(), 0, y, 0, dimension);

        while (between(x + h, parameters.getXStart(), parameters.getXEnd())) {
            double[] nextY = new double[dimension];
            for (int i = 0; i < dimension; i++) {
                nextY[i] = y[i] + h * equationsSystem.getEquation(i).calculate(x, y);
            }
            x = x + h;
            System.arraycopy(nextY, 0, y, 0, dimension);
            solution.addSolution(x, nextY);
            stepNumber++;

            logger.trace("{}: x = {}, y = {}", stepNumber, formatXValue(x), formatYValue(y));
        }

        logger.debug(NAME + " method finished");

        return solution;
    }
}
