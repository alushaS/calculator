package tests;

import calc.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest{

    Calculator calculator;

    @BeforeMethod
    public void beforeMethod() {
        calculator = new Calculator();
        System.out.println("Начало операции");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Операция над числами произведена");
    }
}
