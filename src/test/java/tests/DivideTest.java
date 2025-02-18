package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivideTest extends BaseTest implements ITestsConstants{

    @DataProvider(name = "positive numbers")
    public Object[][] numbers() {
        return new Object[][] {
                {POSITIVE_NUM_8_3, POSITIVE_NUM_2_5},
                {ZERO, POSITIVE_NUM_4_6},
                {POSITIVE_NUM_4_6, POSITIVE_NUM_2_5}
        };
    }

    @DataProvider(name = "negative numbers")
    public Object[][] negativeNumbers() {
        return new Object[][] {
                {NEGATIVE_NUM_8_7, NEGATIVE_NUM_4_2},
                {ZERO, NEGATIVE_NUM_3_4},
        };
    }

    @DataProvider(name = "division by zero")
    public Object[][] divisionByZero() {
        return new Object[][] {
                {5, 0},
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
    public void subtractByZeroTest(int a, int b) {
        String expectedResult = "Делить на ноль нельзя!";
        String actualResult = null;
        try {
             calculator.divideByZero(a, b);
        } catch (ArithmeticException exception) {
            actualResult = "Делить на ноль нельзя!";
            System.out.println(actualResult);
        }
        Assert.assertEquals(actualResult, expectedResult);
    }
}
