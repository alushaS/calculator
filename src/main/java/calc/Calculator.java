package calc;

public class Calculator {

    public double sum(double a, double b) {
        System.out.println("Сумма чисел: " + a +  " и " + b + " = " + (a + b));
        return a + b;
    }

    public double subtract(double a, double b) {
        System.out.println("Разность чисел: " + a +  " и " + b + " = " + (a - b));
        return a - b;
    }

    public double multiply(double a, double b) {
        System.out.println("Произведение чисел: " + a +  " и " + b + " = " + (a * b));
        return a * b;
    }

    public double divide(double a, double b) {
        System.out.println("Частное чисел: " + a +  " и " + b + " = " + (a / b));
        return a / b;
    }

    public double divideByZero(int a, int b, int exprectedResult) {
        System.out.println("Частное чисел: " + a +  " и " + b + " = " + (a / b));
        if (b == 0){
            throw new ArithmeticException("division by zero");
        }
        return a / b;
    }
}
