package org.example;

public class MainApp {

    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
    public double divide(int a, int b) {
    if(b == 0) throw new ArithmeticException("Division by zero");
    return a / (double) b;
    }
    public boolean isEven(int n) { return n % 2 == 0; }
    public int factorial(int n) {
    if(n < 0) throw new IllegalArgumentException("Negative number");
    int f = 1;
    for (int i = 1; i <= n; i++) f *= i;
    return f;
    }
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    public boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i = 2; i*i <= n; i++)
            if(n % i == 0) return false;
        return true;
    }
}
