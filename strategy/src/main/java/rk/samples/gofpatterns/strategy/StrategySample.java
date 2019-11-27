package rk.samples.gofpatterns.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rk.samples.gofpatterns.strategy.methods.EulerMethod;
import rk.samples.gofpatterns.strategy.methods.RungeKuttaMethod;
import rk.samples.gofpatterns.strategy.resolver.DifferentialEquationsSystemResolver;
import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystem;
import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystemSolvingParameters;

public class StrategySample {
    private static final Logger logger = LogManager.getLogger(StrategySample.class);

    public static void main(String[] args) {
        DifferentialEquationsSystemResolver resolver = new DifferentialEquationsSystemResolver();

        DifferentialEquationsSystemSolvingParameters parameters = new DifferentialEquationsSystemSolvingParameters();
        parameters.setInterval(0, 1);
        double[] y0 = {1};
        parameters.setY0(y0);
        parameters.setStep(0.1);

        DifferentialEquationsSystem system = new DifferentialEquationsSystem(1);
        system.setEquation(0, (x, y) -> 2 - Math.exp(-4.0 * x) - 2 * y[0]);

        resolver.setParameters(parameters);
        resolver.setEquationsSystem(system);
        resolver.setMethod(new EulerMethod());

        logger.info(resolver.solve());

        resolver.setMethod(new RungeKuttaMethod());

        logger.info(resolver.solve());
    }
}
