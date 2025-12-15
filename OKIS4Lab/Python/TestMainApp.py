import pytest
from MainApp import MainApp

app = MainApp()

#2 Тест на сложение
@pytest.mark.arithmetic
def test_add():
    assert app.add(5, 7) == 12

#1 Тест на вычитание
@pytest.mark.arithmetic
def test_subtract():
    assert app.subtract(10, 3) == 7

#3 Тест на умножениеpytest TestMainApp.py
@pytest.mark.arithmetic
def test_multiply():
    assert app.multiply(4, 5) == 20

#4 Тест на деление
@pytest.mark.arithmetic
def test_divide():
    assert app.divide(20, 4) == 5.0

#5 Тест на деление на ноль (исключение)
@pytest.mark.exception
def test_divide_by_zero():
    with pytest.raises(ZeroDivisionError):
        app.divide(10, 0)

#6 Тест на чётность
@pytest.mark.logic
def test_is_even():
    assert app.is_even(8)
    assert not app.is_even(7)

#7 Тест факториала
@pytest.mark.logic
def test_factorial():
    assert app.factorial(5) == 120

#8 Тест факториала с отрицательным числом (исключение)
@pytest.mark.exception
def test_factorial_negative():
    with pytest.raises(ValueError):
        app.factorial(-1)

#9 Тест на реверс строки
@pytest.mark.string
def test_reverse_string():
    assert app.reverse_string("abc") == "cba"

#10 Тест на пустую строку
@pytest.mark.string
def test_reverse_empty_string():
    assert app.reverse_string("") == ""

#11 Тест на простое число
@pytest.mark.logic
def test_is_prime():
    assert app.is_prime(7)
    assert not app.is_prime(8)

#12 Тест с параметризацией (разные суммы)
@pytest.mark.arithmetic
@pytest.mark.parametrize("a,b,expected", [
    (1, 2, 3),
    (2, 5, 7),
    (0, 0, 0),
    (-3, 3, 0)
])
def test_add_param(a, b, expected):
    assert app.add(a, b) == expected
