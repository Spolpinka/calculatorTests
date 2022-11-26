package pro.sky.calculator.calculatortests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.calculator.calculatortests.service.CalcService;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private int num1;
    private int num2;

    private CalcService calcService;

    @BeforeEach
    public void setUp(){
        Random random = new Random();
        num1 = random.nextInt();
        num2 = random.nextInt();
        calcService = new CalcService();
    }
    @Test
    public void plus(){
        int expected = num1 + num2;
        int result = calcService.sum(num1, num2);

        assertEquals(expected, result);
    }
    @Test
    public void minus(){
        int expected = num1 - num2;
        int result = calcService.minus(num1, num2);

        assertEquals(expected, result);
    }
    @Test
    public void multiply(){
        int expected = num1 * num2;
        int result = calcService.multiple(num1, num2);

        assertEquals(expected, result);
    }
    @Test
    public void divide(){
        float expected = (float) num1 / num2;
        float result = calcService.divide(num1, num2);

        assertEquals(expected, result);
    }
}

