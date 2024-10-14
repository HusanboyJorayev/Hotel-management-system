package org.example.hotel_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthRequest {
    private String username;
    private String phoneNumber;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private Integer age;
}
