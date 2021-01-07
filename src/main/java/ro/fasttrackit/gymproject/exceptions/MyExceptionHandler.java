package ro.fasttrackit.gymproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GymError handleNotFoundException(NotFoundException notFoundException) {
        return new GymError(notFoundException.getMessage());
    }
}

class GymError {
    public final String message;

    public GymError(String message) {
        this.message = message;
    }
}
