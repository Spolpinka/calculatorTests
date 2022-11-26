package pro.sky.calculator.calculatortests.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator.calculatortests.exceptions.DivideForNullException;
import pro.sky.calculator.calculatortests.service.CalcService;

@RestController
@RequestMapping("/calculator")
public class CalcController {
    private CalcService calcService;

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping()
    public String printGreetings() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(int num1, int num2) {
        return num1 + " + " + num2 + " = " + calcService.sum(num1, num2);
    }

    @GetMapping("/minus")
    public String minus(int num1, int num2) {
        return num1 + " - " + num2 + " = " + calcService.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply(int num1, int num2) {
        return num1 + " * " + num2 + " = " + calcService.multiple(num1, num2);
    }

    @GetMapping("/divide")
    public String divide(int num1, int num2) {
        try {
            return num1 + " / " + num2 + " = " + calcService.divide(num1, num2);
        } catch (DivideForNullException e) {
            return "Нельзя делить на 0 (ноль)!!!";
        }
    }
}
