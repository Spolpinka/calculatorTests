package pro.sky.calculator.calculatortests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.calculator.calculatortests.exceptions.DivideForNullException;
import pro.sky.calculator.calculatortests.service.CalcService;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private int num1;
    private int num2;
    private int num3;
    private int num4;

    private CalcService calcService;

    @BeforeEach
    public void setUp() {
        Random random = new Random();
        num1 = random.nextInt();
        num2 = random.nextInt();
        num3 = random.nextInt();
        num4 = random.nextInt();
        calcService = new CalcService();
    }

    @Test
    public void plus() {
        int expected = num1 + num2;
        int result = calcService.sum(num1, num2);

        assertEquals(expected, result);

        assertEquals(num3 + num4, calcService.sum(num3, num4));
    }

    @Test
    public void minus() {
        int expected = num1 - num2;
        int result = calcService.minus(num1, num2);

        assertEquals(expected, result);

        assertEquals(num3 - num4, calcService.minus(num3, num4));
    }

    @Test
    public void multiply() {
        int expected = num1 * num2;
        int result = calcService.multiple(num1, num2);

        assertEquals(expected, result);

        assertEquals(num3 * num4, calcService.multiple(num3, num4));
    }

    @Test
    public void divide() {
        float expected = (float) num1 / num2;
        float result = calcService.divide(num1, num2);

        assertEquals(expected, result);

        assertEquals((float) num3 / num4, calcService.divide(num3, num4));
    }

    //параметеризованные тесты
    @ParameterizedTest
    @MethodSource("plusTestSource")
    public void plusTest(int num1, int num2, int result) {
        assertEquals(result, calcService.sum(num1, num2));
    }

    public static List<Arguments> plusTestSource() {
        return List.of(
                Arguments.of(25, 5, 30),
                Arguments.of(-455, 10, -445));
    }

    @ParameterizedTest
    @MethodSource("minusTestSource")
    public void minusTest(int num1, int num2, int result) {
        assertEquals(result, calcService.minus(num1, num2));
    }

    public static List<Arguments> minusTestSource() {
        return List.of(
                Arguments.of(10, 5, 5),
                Arguments.of(-555, 555, -1110),
                Arguments.of(333, -3, 336)
        );
    }

    @ParameterizedTest
    @MethodSource("multiTestSource")
    public void multiplyTest(int num1, int num2, int result) {
        assertEquals(result, calcService.multiple(num1, num2));
    }

    public static List<Arguments> multiTestSource() {
        return List.of(
                Arguments.of(1, 23453, 23453),
                Arguments.of(55, 5, 275),
                Arguments.of(-5, 10, -50)
        );
    }

    @ParameterizedTest
    @MethodSource("divideTestSource")
    public void divideTest(int num1, int num2, int result) {
        assertEquals(result, calcService.divide(num1, num2));
    }

    public static List<Arguments> divideTestSource() {
        return List.of(
                Arguments.of(5, 5, 1),
                Arguments.of(-10, 2, -5),
                Arguments.of(35, 5, 7)
        );
    }

    //тест выбрасывания исключения
    @Test
    public void divideForNullThrowsTest(){
        assertThrows(DivideForNullException.class, () -> {
            calcService.divide(23, 0);
        });
    }
}

