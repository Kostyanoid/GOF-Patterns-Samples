package rk.samples.gofpatterns.strategy.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DecimalFormatter {
    private static final DecimalFormat formatForXValue = new DecimalFormat("0.0000");
    private static final DecimalFormat formatForYValue = new DecimalFormat("0.000000000000");

    private DecimalFormatter() {
    }

    static {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        symbols.setGroupingSeparator(' ');
        formatForXValue.setDecimalFormatSymbols(symbols);
        formatForYValue.setDecimalFormatSymbols(symbols);
    }

    public static String formatXValue(double x) {
        return formatForXValue.format(x);
    }

    public static String formatYValue(double[] y) {
        return arrayOfNumbersToString(y, formatForYValue);
    }


    private static String arrayOfNumbersToString(double[] array, DecimalFormat format) {
        return Arrays.stream(array).mapToObj(format::format).collect(Collectors.joining(", ","[","]"));
    }
}
