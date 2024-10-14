package org.example.hotel_management_system.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthRequest {
    private String phoneNumber;
    @NotBlank(message = "email cannot be null or empty")
    private String email;
    private String firstname;
    private String lastname;
    private Integer age;
}
