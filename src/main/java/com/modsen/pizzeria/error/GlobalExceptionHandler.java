package com.modsen.pizzeria.error;

import com.modsen.pizzeria.exception.DuplicateResourceException;
import com.modsen.pizzeria.exception.InvalidOrderStatusException;
import com.modsen.pizzeria.exception.ResourceNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AppError handleResourceNotFound(ResourceNotFoundException e) {
        return new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AppError handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        List<String> errorMessages = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        String errors = String.join(", ", errorMessages);
        return new AppError(HttpStatus.BAD_REQUEST.value(), errors, LocalDateTime.now());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AppError handleConstraintViolation(ConstraintViolationException e) {
        List<String> errorMessages = e.getConstraintViolations().stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .collect(Collectors.toList());
        String errors = String.join(", ", errorMessages);
        return new AppError(HttpStatus.BAD_REQUEST.value(), errors, LocalDateTime.now());
    }

    @ExceptionHandler(DuplicateResourceException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public AppError handleDuplicateResourceException(DuplicateResourceException e) {
        return new AppError(HttpStatus.CONFLICT.value(), e.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(InvalidOrderStatusException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AppError handleInvalidOrderStatusException(InvalidOrderStatusException e) {
        return new AppError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), LocalDateTime.now());
    }
}