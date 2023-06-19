package fr.orionbs.guardian.adapter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class NotFoundExceptionAdapter {

    @ExceptionHandler({NoHandlerFoundException.class})
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public String handleNoHandlerFoundException(NoHandlerFoundException noHandlerFoundException) {
        return "Resource not found";
    }

}
