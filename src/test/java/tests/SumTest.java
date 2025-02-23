package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class SumTest extends BaseTest{

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

    @Test(dataProvider = "positive numbers", description = "Summarize only positive numbers including zero test", priority = 3)
    public void summarizePositiveNumbersTest(double a, double b) {
        double result =  calculator.sum(a, b);
        Assert.assertEquals(result, (a + b));
    }

    @Test(dataProvider = "negative numbers", description = "Summarize only negative numbers and zero test", priority = 4)
    public void summarizeNegativeNumbersTest(double a, double b) {
        double result =  calculator.sum(a, b);
        Assert.assertEquals(result, (a + b));
    }
}
