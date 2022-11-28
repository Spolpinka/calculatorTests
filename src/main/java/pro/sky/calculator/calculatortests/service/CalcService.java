package pro.sky.calculator.calculatortests.service;

import org.springframework.stereotype.Service;
import pro.sky.calculator.calculatortests.exceptions.DivideForNullException;

@Service
public class CalcService {

    public int sum(int num1, int num2) {
        if (isChecked(num1, num2)) {
            return num1 + num2;
        }
        return 0;
    }

    public int minus(int num1, int num2) {
        if (isChecked(num1, num2)) {
            return num1 - num2;
        }
        return 0;
    }

    public int multiple(int num1, int num2) {
        if (isChecked(num1, num2)) {
            return num1 * num2;
        }
        return 0;
    }

    public float divide(int num1, int num2) {
        if (num2 == 0) {
            throw new DivideForNullException("Нельзя делить на 0 (ноль)!!!");
        } else if (isChecked(num1, num2)) {
            return (float) num1 / num2;
        }
        return 0;
    }

    private boolean isChecked(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            throw new IllegalArgumentException();
        } else {
            return true;
        }
    }
}
