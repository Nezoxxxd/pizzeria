package com.modsen.pizzeria.error;

import com.modsen.pizzeria.dto.error.AppError;
import com.modsen.pizzeria.dto.error.AppErrorCustom;
import com.modsen.pizzeria.exception.DuplicateResourceException;
import com.modsen.pizzeria.exception.InvalidOrderStatusException;
import com.modsen.pizzeria.exception.ResourceNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AppError handleResourceNotFound(ResourceNotFoundException e) {
        return AppError.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AppErrorCustom handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        Map<String, String> errors = e.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, error -> Objects.requireNonNullElse(error.getDefaultMessage(), "No message available")));
        return AppErrorCustom.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(errors)
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AppErrorCustom handleConstraintViolation(ConstraintViolationException e) {
        Map<String, String> errors = e.getConstraintViolations().stream()
                .collect(Collectors.toMap(
                        violation -> violation.getPropertyPath().toString(),
                        ConstraintViolation::getMessage
                ));
        return AppErrorCustom.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(errors)
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(DuplicateResourceException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public AppError handleDuplicateResourceException(DuplicateResourceException e) {
        return AppError.builder()
                .status(HttpStatus.CONFLICT.value())
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(InvalidOrderStatusException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AppError handleInvalidOrderStatusException(InvalidOrderStatusException e) {
        return AppError.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(e.getMessage())
                .build();
    }
}