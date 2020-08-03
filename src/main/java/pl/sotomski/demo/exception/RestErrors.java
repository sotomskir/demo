package pl.sotomski.demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class RestErrors {
    private final int status;
    private final String error;
    private final String message;

    public RestErrors(HttpStatus httpStatus, String message) {
        this.status = httpStatus.value();
        this.error = httpStatus.toString();
        this.message = message;
    }
}
