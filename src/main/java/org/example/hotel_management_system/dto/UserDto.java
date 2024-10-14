package org.example.hotel_management_system.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hotel_management_system.roles.UserRole;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Integer id;
    private String password;
    private String username;
    private String email;
    private String firstname;
    private String lastname;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private String phoneNumber;
}
