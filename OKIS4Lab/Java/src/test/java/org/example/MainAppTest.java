package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainAppTest {

    private final MainApp app = new MainApp();

    // 1 Тест на сложение
    @Test(groups = {"arithmetic"})
    public void testAdd() {
        // ARRANGE
        final int A = 5;
        final int B = 7;
        final int EXPECTED = 12;
        int result;

        // ACT
        result = app.add(A, B);

        // ASSERT
        Assert.assertEquals(result, EXPECTED);
    }

    // 2 Тест на вычитание
    @Test(groups = {"arithmetic"})
    public void testSubtract() {
        // ARRANGE
        final int A = 10;
        final int B = 3;
        final int EXPECTED = 7;
        int result;

        // ACT
        result = app.subtract(A, B);

        // ASSERT
        Assert.assertEquals(result, EXPECTED);
    }

    // 3 Тест на умножение
    @Test(groups = {"arithmetic"})
    public void testMultiply() {
        // ARRANGE
        final int A = 4;
        final int B = 5;
        final int EXPECTED = 20;
        int result;

        // ACT
        result = app.multiply(A, B);

        // ASSERT
        Assert.assertEquals(result, EXPECTED);
    }

    // 4 Тест на деление
    @Test(groups = {"arithmetic"})
    public void testDivide() {
    // ARRANGE
    final int A = 20;
    final int B = 4;
    final double EXPECTED = 5.0;
    final double EPSILON = 1e-9;
    double result;

    // ACT
    result = app.divide(A, B);

    // ASSERT
    Assert.assertEquals(result, EXPECTED, EPSILON);
    }

    // 5 Тест на деление на ноль (исключение)
    @Test(groups = {"exception"}, expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        // ARRANGE
        final int A = 10;
        final int B = 0;
        final double EPSILON = 1e-9;

        // ACT
        app.divide(A, B, EPSILON);

        // ASSERT
        // ожидаем исключение
    }

    // 6 Тест на чётность
    @Test(groups = {"logic"})
    public void testIsEven() {
        // ARRANGE
        final int EVEN = 8;
        final int ODD = 7;
        boolean evenResult;
        boolean oddResult;

        // ACT
        evenResult = app.isEven(EVEN);
        oddResult = app.isEven(ODD);

        // ASSERT
        Assert.assertTrue(evenResult);
        Assert.assertFalse(oddResult);
    }

    // 7 Тест факториала
    @Test(groups = {"logic"})
    public void testFactorial() {
        // ARRANGE
        final int VALUE = 5;
        final int EXPECTED = 120;
        int result;

        // ACT
        result = app.factorial(VALUE);

        // ASSERT
        Assert.assertEquals(result, EXPECTED);
    }

    // 8 Тест факториала с отрицательным числом (исключение)
    @Test(groups = {"exception"}, expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        // ARRANGE
        final int VALUE = -1;

        // ACT
        app.factorial(VALUE);

        // ASSERT
        // ожидаем исключение
    }

    // 9 Тест на реверс строки
    @Test(groups = {"string"})
    public void testReverseString() {
        // ARRANGE
        final String INPUT = "abc";
        final String EXPECTED = "cba";
        String result;

        // ACT
        result = app.reverseString(INPUT);

        // ASSERT
        Assert.assertEquals(result, EXPECTED);
    }

    // 10 Тест на пустую строку
    @Test(groups = {"string"})
    public void testReverseEmptyString() {
        // ARRANGE
        final String INPUT = "";
        final String EXPECTED = "";
        String result;

        // ACT
        result = app.reverseString(INPUT);

        // ASSERT
        Assert.assertEquals(result, EXPECTED);
    }

    // 11 Тест на простое число
    @Test(groups = {"logic"})
    public void testIsPrime() {
        // ARRANGE
        final int PRIME = 7;
        final int NOT_PRIME = 8;
        boolean primeResult;
        boolean notPrimeResult;

        // ACT
        primeResult = app.isPrime(PRIME);
        notPrimeResult = app.isPrime(NOT_PRIME);

        // ASSERT
        Assert.assertTrue(primeResult);
        Assert.assertFalse(notPrimeResult);
    }

    // 12 DataProvider для сложения
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
        // ARRANGE
        int result;

        // ACT
        result = app.add(a, b);

        // ASSERT
        Assert.assertEquals(result, expected);
    }
}


