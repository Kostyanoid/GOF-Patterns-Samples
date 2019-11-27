package rk.samples.gofpatterns.strategy.utils;

public class NumbersUtil {
    private NumbersUtil() {

    }

    public static boolean between(double x, double firstBound, double secondBound) {
        if (firstBound >= secondBound) {
            return x >= secondBound && x <= firstBound;
        } else {
            return x >= firstBound && x <= secondBound;
        }
    }
}
