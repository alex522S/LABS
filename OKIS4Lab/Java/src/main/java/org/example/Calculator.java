package org.example;

public class Calculator {

    // 1. Сложение
    public int add(int a, int b) {
        return a + b;
    }

    // 2. Вычитание
    public int subtract(int a, int b) {
        return a - b;
    }

    // 3. Умножение
    public int multiply(int a, int b) {
        return a * b;
    }

    // 4. Деление (с проверкой на 0)
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero!");
        }
        return (double) a / b;
    }

    // 5. Проверка чётности
    public boolean isEven(int a) {
        return a % 2 == 0;
    }

    // Дополнительно: Возведение в степень
    public int power(int a, int b) {
        return (int) Math.pow(a, b);
    }
}