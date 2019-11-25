package rk.samples.gofpatterns.strategy.structures;

import java.util.ArrayList;
import java.util.List;

public class DifferentialEquationsSystem {
    private int dimension;
    private List<Differential> equations;

    public DifferentialEquationsSystem(int dimension) {
        this.dimension = dimension;
        this.equations = new ArrayList<>(dimension);
    }

    public int getDimension() {
        return dimension;
    }

    public void setEquations(List<Differential> equations) {
        checkNewEquationsListDimension(equations);
        this.equations.addAll(equations);
    }

    public Differential getEquation(int index) {
        checkEquationIndex(index);
        return equations.get(index);
    }

    public void setEquation(int index, Differential equation) {
        checkEquationIndex(index);
        equations.add(index, equation);
    }

    private void checkEquationIndex(int index) {
        if (index < 0 || index >= dimension)
            throw new IllegalArgumentException("Equation's index must be between 0 and " + (dimension - 1) + ". Presented: " + index);
    }

    private void checkNewEquationsListDimension(List<Differential> equations) {
        if (equations.size() != dimension)
            throw new IllegalStateException("The new equations list's dimension " + equations.size() + " is not fit this equations system's dimension: " + dimension);
    }

}
