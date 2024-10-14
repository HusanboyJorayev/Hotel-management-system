package org.example.hotel_management_system.exception;



import org.example.hotel_management_system.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler()
    public ApiResponse response(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ApiResponse(400, "Validation failed", HttpStatus.BAD_REQUEST, errors);
    }

    @ExceptionHandler()
    public ApiResponse exception(Exception e) {
        Map<String, String> errors = new HashMap<>();

        errors.put("username", e.getMessage());
        return new ApiResponse(400, e.getMessage(), HttpStatus.BAD_REQUEST, errors);
    }
}
