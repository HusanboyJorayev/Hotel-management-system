package org.example.hotel_management_system;

import org.example.hotel_management_system.entity.User;
import org.example.hotel_management_system.repository.UserRepository;
import org.example.hotel_management_system.roles.UserRole;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HotelManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelManagementSystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository userRepository) {
        return args -> {
            User admin = User.builder()
                    .age(21)
                    .code("1111")
                    .email("admin@gmail.com")
                    .role(UserRole.ADMIN)
                    .firstname("Husanboy")
                    .lastname("Jorayev")
                    .phoneNumber("123456789")
                    .password("1111")
                    .build();
            userRepository.save(admin);

            User superAdmin = User.builder()
                    .age(21)
                    .code("2222")
                    .email("superAdmin@gmail.com")
                    .role(UserRole.SUPER_ADMIN)
                    .firstname("Husanboy")
                    .lastname("Jorayev")
                    .phoneNumber("123456789")
                    .password("2222")
                    .build();
            userRepository.save(superAdmin);
        };
    }
}
