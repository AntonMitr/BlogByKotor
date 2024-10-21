package com.blog.by.kotor.exception;

import com.blog.by.kotor.dto.error.ErrorResponseDTO;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.exception.find.by.name.FindByNameException;
import com.blog.by.kotor.exception.signup.SignupException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDTO handleThrowable(Throwable ex) {
        log.error(ex.getMessage());
        return ErrorResponseDTO.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(ex.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleValidationExceptions(MethodArgumentNotValidException ex) {
        StringBuilder errorMessage = new StringBuilder("Ошибки валидации! ");
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMessage.append(String.format("%s: %s. ", error.getField(), error.getDefaultMessage()));
        });
        log.error(errorMessage.toString());
        return ErrorResponseDTO.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(errorMessage.toString())
                .build();
    }

    @ExceptionHandler(SignupException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponseDTO handleSignupException(SignupException ex) {
        log.error(ex.getMessage());
        return ErrorResponseDTO.builder()
                .status(HttpStatus.CONFLICT)
                .message(ex.getMessage())
                .build();
    }

    @ExceptionHandler({FindByIdException.class, FindByNameException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleNotFoundException(Exception ex) {
        log.error(ex.getMessage());
        return ErrorResponseDTO.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(ex.getMessage())
                .build();
    }

}
