package org.example;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    public static void main(String[] args) {
        testCalculateDiscount();
        testCalculateDiscountWithInvalidInput();
    }

    private static void testCalculateDiscount() {
        // Тест с корректными входными значениями
        assertThat(Calculator.calculateDiscount(100.0, 10.0)).isEqualTo(90.0);

        // Тест с максимальной скидкой
        assertThat(Calculator.calculateDiscount(200.0, 100.0)).isEqualTo(0.0);

        // Тест с нулевой скидкой
        assertThat(Calculator.calculateDiscount(150.0, 0.0)).isEqualTo(150.0);
    }

    private static void testCalculateDiscountWithInvalidInput() {
        // Тест с отрицательной суммой покупки
        assertThatThrownBy(() -> Calculator.calculateDiscount(-100.0, 10.0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("Invalid input");

        // Тест с отрицательным процентом скидки
        assertThatThrownBy(() -> Calculator.calculateDiscount(100.0, -10.0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("Invalid input");

        // Тест с процентом скидки больше 100
        assertThatThrownBy(() -> Calculator.calculateDiscount(100.0, 110.0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("Invalid input");
    }
}