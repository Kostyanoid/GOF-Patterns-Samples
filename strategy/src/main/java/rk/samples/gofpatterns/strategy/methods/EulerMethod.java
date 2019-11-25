package rk.samples.gofpatterns.strategy.methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystem;
import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystemSolution;
import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystemSolvingParameters;

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
        double x = parameters.getxStart();
        double h = parameters.getStep();
        double[] y = parameters.getY0();
        int dimenssion = equationsSystem.getDimension();
        int stepNumber = 0;

        logger.info(NAME + " method started.");
        logger.trace("x0: {}, y0: {}, step: {}", x, y, h);

        solution.addSolution(x, y);

        while (between(x + h, parameters.getxStart(), parameters.getxEnd())) {
            double[] nextY = new double[dimenssion];
            for (int i = 0; i < dimenssion; i++) {
                nextY[i] = y[i] + h * equationsSystem.getEquation(i).calculate(x, y);
            }
            x = x + h;
            System.arraycopy(nextY, 0, y, 0, dimenssion);
            solution.addSolution(x, y);
            stepNumber++;

            logger.trace("{}: x = {}, y = {}", stepNumber, x, y);
        }

        logger.info(NAME + " method finished");

        return solution;
    }

    private boolean between(double x, double firstBound, double secondBound) {
        if (firstBound >= secondBound) {
            return x >= secondBound && x <= firstBound;
        } else {
            return x >= firstBound && x <= secondBound;
        }
    }
}
