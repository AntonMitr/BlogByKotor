package com.blog.by.kotor.exception;

import com.blog.by.kotor.dto.error.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleThrowable(Throwable ex) {
        return new ErrorResponseDTO(HttpStatus.NOT_FOUND ,ex.getMessage());
    }

}
