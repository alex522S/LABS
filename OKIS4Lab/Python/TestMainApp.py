import pytest
from MainApp import MainApp

app = MainApp()

# 1 Тест на сложение
@pytest.mark.arithmetic
def test_add():
    # ARRANGE
    A = 5
    B = 7
    EXPECTED = 12

    # ACT
    result = app.add(A, B)

    # ASSERT
    assert result == EXPECTED


# 2 Тест на вычитание
@pytest.mark.arithmetic
def test_subtract():
    # ARRANGE
    A = 10
    B = 3
    EXPECTED = 7

    # ACT
    result = app.subtract(A, B)

    # ASSERT
    assert result == EXPECTED


# 3 Тест на умножение
@pytest.mark.arithmetic
def test_multiply():
    # ARRANGE
    A = 4
    B = 5
    EXPECTED = 20

    # ACT
    result = app.multiply(A, B)

    # ASSERT
    assert result == EXPECTED


# 4 Тест на деление
@pytest.mark.arithmetic
def test_divide():
    # ARRANGE
    A = 20
    B = 4
    EXPECTED = 5.0

    # ACT
    result = app.divide(A, B)

    # ASSERT
    assert result == EXPECTED


# 5 Тест на деление на ноль (исключение)
@pytest.mark.exception
def test_divide_by_zero():
    # ARRANGE
    A = 10
    B = 0

    # ACT + ASSERT
    with pytest.raises(ZeroDivisionError):
        app.divide(A, B)


# 6 Тест на чётность
@pytest.mark.logic
def test_is_even():
    # ARRANGE
    EVEN = 8
    ODD = 7

    # ACT
    even_result = app.is_even(EVEN)
    odd_result = app.is_even(ODD)

    # ASSERT
    assert even_result is True
    assert odd_result is False


# 7 Тест факториала
@pytest.mark.logic
def test_factorial():
    # ARRANGE
    VALUE = 5
    EXPECTED = 120

    # ACT
    result = app.factorial(VALUE)

    # ASSERT
    assert result == EXPECTED


# 8 Тест факториала с отрицательным числом (исключение)
@pytest.mark.exception
def test_factorial_negative():
    # ARRANGE
    VALUE = -1

    # ACT + ASSERT
    with pytest.raises(ValueError):
        app.factorial(VALUE)


# 9 Тест на реверс строки
@pytest.mark.string
def test_reverse_string():
    # ARRANGE
    INPUT = "abc"
    EXPECTED = "cba"

    # ACT
    result = app.reverse_string(INPUT)

    # ASSERT
    assert result == EXPECTED


# 10 Тест на пустую строку
@pytest.mark.string
def test_reverse_empty_string():
    # ARRANGE
    INPUT = ""
    EXPECTED = ""

    # ACT
    result = app.reverse_string(INPUT)

    # ASSERT
    assert result == EXPECTED


# 11 Тест на простое число
@pytest.mark.logic
def test_is_prime():
    # ARRANGE
    PRIME = 7
    NOT_PRIME = 8

    # ACT
    prime_result = app.is_prime(PRIME)
    not_prime_result = app.is_prime(NOT_PRIME)

    # ASSERT
    assert prime_result is True
    assert not_prime_result is False


# 12 Тест с параметризацией (сложение)
@pytest.mark.arithmetic
@pytest.mark.parametrize("a, b, expected", [
    (1, 2, 3),
    (2, 5, 7),
    (0, 0, 0),
    (-3, 3, 0)
])
def test_add_param(a, b, expected):
    # ARRANGE
    # параметры заданы через parametrize

    # ACT
    result = app.add(a, b)

    # ASSERT
    assert result == expected
