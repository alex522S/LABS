package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider; // подключаем DataProvider, чтобы создавать тесты с разными входными значениями.
import org.testng.annotations.Test; // подключаем аннотацию @Test, которая говорит TestNG: “Этот метод — тест, его нужно запускать”

public class MainAppTest {

    MainApp app = new MainApp();

    // 1Тест на сложение
    @Test(groups = {"arithmetic"})
    public void testAdd() {
        int a = 5;
        int b = 7;
        int expected = 12;
        int result = app.add(a, b);
        Assert.assertEquals(result, expected);
    }

    // 2Тест на вычитание
    @Test(groups = {"arithmetic"})
    public void testSubtract() {
        int result = app.subtract(10, 3);
        Assert.assertEquals(result, 7);
    }

    // 3Тест на умножение
    @Test(groups = {"arithmetic"})
    public void testMultiply() {
        int result = app.multiply(4, 5);
        Assert.assertEquals(result, 20);
    }

    // 4Тест на деление
    @Test(groups = {"arithmetic"})
    public void testDivide() {
        double result = app.divide(20, 4);
        Assert.assertEquals(result, 5.0);
    }

    // 5Тест на деление на ноль (исключение)
    @Test(groups = {"exception"}, expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        app.divide(10, 0);
    }

    // 6Тест на чётность
    @Test(groups = {"logic"})
    public void testIsEven() {
        Assert.assertTrue(app.isEven(8));
        Assert.assertFalse(app.isEven(7));
    }

    // 7Тест факториала
    @Test(groups = {"logic"})
    public void testFactorial() {
        Assert.assertEquals(app.factorial(5), 120);
    }

    // 8Тест факториала с отрицательным числом (исключение)
    @Test(groups = {"exception"}, expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        app.factorial(-1);
    }

    // 9️Тест на реверс строки
    @Test(groups = {"string"})
    public void testReverseString() {
        Assert.assertEquals(app.reverseString("abc"), "cba");
    }

    // 10Тест на пустую строку
    @Test(groups = {"string"})
    public void testReverseEmptyString() {
        Assert.assertEquals(app.reverseString(""), "");
    }

    // 11Тест на простое число
    @Test(groups = {"logic"})
    public void testIsPrime() {
        Assert.assertTrue(app.isPrime(7));
        Assert.assertFalse(app.isPrime(8));
    }

    // 12Тест с DataProvider (сложение разных чисел)
    @DataProvider(name = "addData")
    public Object[][] addData() {
        return new Object[][]{
                {1, 2, 3},
                {2, 5, 7},
                {0, 0, 0},
                {-3, 3, 0}
        };
    }

    @Test(dataProvider = "addData", groups = {"arithmetic", "param"})
    public void testAddProvider(int a, int b, int expected) {
        int result = app.add(a, b);
        Assert.assertEquals(result, expected);
    }
}
