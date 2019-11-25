package rk.samples.gofpatterns.strategy.methods;

import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystem;
import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystemSolution;
import rk.samples.gofpatterns.strategy.structures.DifferentialEquationsSystemSolvingParameters;

public interface DifferentialEquationsSystemSolvingMethod {
    String getName();

    DifferentialEquationsSystemSolution solve(DifferentialEquationsSystem equationsSystem, DifferentialEquationsSystemSolvingParameters parameters);
}
