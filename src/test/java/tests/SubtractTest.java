package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubtractTest extends BaseTest{

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

    @Test(dataProvider = "positive numbers", description = "Subtract only positive numbers including zero test", priority = 1)
    public void subtractPositiveNumbersTest(double a, double b) {
        double result =  calculator.subtract(a, b);
        Assert.assertEquals(result, (a -b));
    }

    @Test(dataProvider = "negative numbers", description = "Subtract only negative numbers and zero test", priority = 2)
    public void subtractNegativeNumbersTest(double a, double b) {
        double result =  calculator.subtract(a, b);
        Assert.assertEquals(result, (a -b));
    }
}
