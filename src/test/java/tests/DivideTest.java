package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivideTest extends BaseTest{

    @DataProvider(name = "positive numbers")
    public Object[][] numbers() {
        return new Object[][] {
                {8.3, 2.5},
                {0, 4.6},
                {4.6, 2.5}
        };
    }

    @DataProvider(name = "negative numbers")
    public Object[][] negativeNumbers() {
        return new Object[][] {
                {-8.7, -4.2},
                {0, 3.4},
        };
    }

    @DataProvider(name = "division by zero")
    public Object[][] divisionByZero() {
        return new Object[][] {
                {5, 0, 0},
        };
    }

    @Test(dataProvider = "positive numbers", description = "Subtract only positive numbers including zero test", priority = 5)
    public void subtractPositiveNumbersTest(double a, double b) {
        double result =  calculator.divide(a, b);
        Assert.assertEquals(result, (a / b));
    }

    @Test(dataProvider = "negative numbers", description = "Subtract only negative numbers and zero test", priority = 6)
    public void subtractNegativeNumbersTest(double a, double b) {
        double result =  calculator.divide(a, b);
        Assert.assertEquals(result, (a / b));
    }


    @Test(retryAnalyzer = Retry.class, dataProvider = "division by zero", description = "Division by zero test", priority = 7)
    public void divideByZeroTest(int a, int b, double expectedResult) {
        try {
            double result = calculator.divide(a, b);
            Assert.assertEquals(result, expectedResult);
        } catch (ArithmeticException e) {
            Assert.assertEquals(b, 0);
        }
    }
}

