package org.example.hotel_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private int code;
    private String message;
    private HttpStatus status;
    private Map<String, String> errors;
}
