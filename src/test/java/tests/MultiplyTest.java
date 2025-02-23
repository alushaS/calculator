package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplyTest extends BaseTest{

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
                {0, -3.4},
                {4.2, 0}
        };
    }

    @Test(dataProvider = "positive numbers", description = "Multiply only positive numbers including zero test", priority = 8, invocationCount = 2, threadPoolSize = 2)
    public void multiplyPositiveNumbersTest(double a, double b) {
        double result =  calculator.multiply(a, b);
        Assert.assertEquals(result, (a * b));
    }

    @Test(dataProvider = "negative numbers", description = "Multiply only negative numbers and zero test", priority = 9, invocationCount = 2, threadPoolSize = 2)
    public void multiplyNegativeNumbersTest(double a, double b) {
        double result =  calculator.multiply(a, b);
        Assert.assertEquals(result, (a * b));
    }
}
