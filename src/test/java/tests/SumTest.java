package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class SumTest extends BaseTest implements ITestsConstants{

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
                {NEGATIVE_NUM_4_2, ZERO}
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
