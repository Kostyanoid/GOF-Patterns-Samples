package rk.samples.gofpatterns.strategy.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DifferentialEquationsSystemSolution {
    private List<ByPointSolution> byPointSolutions = new ArrayList<>();

    public void addSolution(double x, double[] y) {
        ByPointSolution newSolution = new ByPointSolution(x, y);
        byPointSolutions.add(newSolution);
    }

    public List<ByPointSolution> retriveSolution() {
        sortSolutionsByX();

        return byPointSolutions;
    }

    private void sortSolutionsByX() {
        byPointSolutions.sort(Comparator.comparingDouble(ByPointSolution::getX));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Solution: \n");
        byPointSolutions.forEach(solution -> stringBuilder.append(solution.toString()).append("\n"));
        return stringBuilder.toString();
    }


    public class ByPointSolution {
        double x;
        double[] y;

        public ByPointSolution(double x, double[] y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double[] getY() {
            return y;
        }

        public void setY(double[] y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "x: " + x +
                    " y = " + Arrays.stream(y).mapToObj(String::valueOf).collect(Collectors.joining(", ", "(", ");"));
        }
    }
}
