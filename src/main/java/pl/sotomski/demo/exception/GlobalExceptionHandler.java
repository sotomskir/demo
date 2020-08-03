package pl.sotomski.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UnsupportedException.class)
    public ResponseEntity<RestErrors> unsupportedOperatorException(UnsupportedException e) {
        return error(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<RestErrors> missingServletRequestParameterException(MissingServletRequestParameterException e) {
        return error(e, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<RestErrors> error(Exception exception, HttpStatus httpStatus) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return ResponseEntity.status(httpStatus).body(new RestErrors(httpStatus, message));
    }
}
