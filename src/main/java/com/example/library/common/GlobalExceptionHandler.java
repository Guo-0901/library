package com.example.library.common;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Result handleRuntime (RuntimeException e) {
        return new Result(500, e.getMessage(), null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleValid (MethodArgumentNotValidException e) {
        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        StringBuilder msg = new StringBuilder();
        for (FieldError error : errors) {
            if (msg.length() > 0) {
                msg.append("；");
            }
            msg.append(error.getDefaultMessage());
        }
        return new Result(400, msg.toString(), null);
    }
}
