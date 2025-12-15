class MainApp:

    def add(self, a, b):
        return a + b

    def subtract(self, a, b):
        return a - b

    def multiply(self, a, b):
        return a * b

    def divide(self, a, b):
        if b == 0:
            raise ZeroDivisionError("Division by zero")
        return a / b

    def is_even(self, n):
        return n % 2 == 0

    def factorial(self, n):
        if n < 0:
            raise ValueError("Negative number")
        f = 1
        for i in range(1, n + 1):
            f *= i
        return f

    def reverse_string(self, s):
        return s[::-1]

    def is_prime(self, n):
        if n < 2:
            return False
        for i in range(2, int(n**0.5) + 1):
            if n % i == 0:
                return False
        return True
