package com.stupidstick.intervals.controller.advice;

import com.stupidstick.intervals.model.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(HandlerMethodValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<ValidationErrorResponse> handleValidationExceptions(HandlerMethodValidationException ex) {
        List<ValidationErrorResponse> errors = new ArrayList<>();
        for (var validationResult : ex.getAllValidationResults()) {
            for (var error: validationResult.getResolvableErrors()) {
                errors.add(new ValidationErrorResponse(validationResult.getArgument(), error.getDefaultMessage()));
            }
        }
        return errors;
    }

}
