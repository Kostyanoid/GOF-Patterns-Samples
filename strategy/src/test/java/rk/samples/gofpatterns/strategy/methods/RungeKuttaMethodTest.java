package rk.samples.gofpatterns.strategy.methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertArrayEquals;

public class RungeKuttaMethodTest {
    private static final Logger logger = LogManager.getLogger("tests");

    private RungeKuttaMethod mock = PowerMockito.mock(RungeKuttaMethod.class);


    @Test
    public void addVectors_whenTwoVectorsAdded_thenResultIsAppropriate() throws Exception {

        double[] v1 = new double[]{0, 1, 2, 3};
        double[] v2 = new double[]{1, 2, 3, 4};
        double[] expectedResult = new double[]{1, 3, 5, 7};

        double[] actualResult = Whitebox.invokeMethod(mock, "addVectors", v1, v2);

        logger.info("addVectors test:");
        logger.trace("v1: {}", v1);
        logger.trace("v2: {}", v2);
        logger.trace("expected result: {}", expectedResult);
        logger.trace("actual result: {}", actualResult);

        assertArrayEquals(actualResult, expectedResult, 0.00001);

    }

    @Test
    public void multipleVectorByNumber_whenMultipleVectorsByNumber_thenResultIsAppropriate() throws Exception {

        double[] v1 = new double[]{0, 1, 2, 3};
        double number = 1.5;
        double[] expectedResult = new double[]{0, 1.5, 3, 4.5};

        double[] actualResult = Whitebox.invokeMethod(mock, "multipleVectorByNumber", v1, number);

        logger.info("multipleVectorByNumber test:");
        logger.trace("vector: {}", v1);
        logger.trace("number: {}", number);
        logger.trace("expected result: {}", expectedResult);
        logger.trace("actual result: {}", actualResult);

        assertArrayEquals(actualResult, expectedResult, 0.00001);

    }

    @Test
    public void linearCombination_whenTwoVectorsLinearCombinated_thenResultIsAppropriate() throws Exception {

        double[] v1 = new double[]{0, 1, 2, 3};
        double[] v2 = new double[]{1, 2, 3, 4};
        double[] coeffs = new double[]{-1.0, 0.5};
        double[] expectedResult = new double[]{0.5, 0, -0.5, -1};

        double[] actualResult = Whitebox.invokeMethod(mock, "linearCombination", coeffs, v1, v2);

        logger.info("linearCombination test:");
        logger.trace("v1: {}", v1);
        logger.trace("v2: {}", v2);
        logger.trace("coeffs: {}", coeffs);
        logger.trace("expected result: {}", expectedResult);
        logger.trace("actual result: {}", actualResult);

        assertArrayEquals(actualResult, expectedResult, 0.00001);

    }

    @Test
    public void linearCombination_whenThreeVectorsLinearCombinated_thenResultIsAppropriate() throws Exception {

        double[] v1 = new double[]{0, 1, 2, 3};
        double[] v2 = new double[]{1, 2, 3, 4};
        double[] v3 = new double[]{5, 0, 0, 0};
        double[] coeffs = new double[]{-1.0, 0.5, 0.1};
        double[] expectedResult = new double[]{1, 0, -0.5, -1};

        double[] actualResult = Whitebox.invokeMethod(mock, "linearCombination", coeffs, v1, v2, v3);

        logger.info("linearCombination test:");
        logger.trace("v1: {}", v1);
        logger.trace("v2: {}", v2);
        logger.trace("v3: {}", v3);
        logger.trace("coeffs: {}", coeffs);
        logger.trace("expected result: {}", expectedResult);
        logger.trace("actual result: {}", actualResult);

        assertArrayEquals(actualResult, expectedResult, 0.00001);

    }
}