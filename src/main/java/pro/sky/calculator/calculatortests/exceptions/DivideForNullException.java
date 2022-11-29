package pro.sky.calculator.calculatortests.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DivideForNullException extends IllegalArgumentException {
    private String message;

    public DivideForNullException(String message) {
        super(message);
    }
}
