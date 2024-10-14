package org.example.hotel_management_system.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.hotel_management_system.entity.User;
import org.example.hotel_management_system.repository.UserRepository;
import org.example.hotel_management_system.roles.UserRole;
import org.example.hotel_management_system.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> updateAdmin(Integer id) {
        Optional<User> optional = this.userRepository.findById(id);
        if (optional.isPresent()) {
            User user = optional.get();
            user.setRole(UserRole.ADMIN);
            this.userRepository.save(user);
            return ResponseEntity.ok("updated successfully");
        }
        return ResponseEntity.ok("User not found");
    }

    @Override
    public ResponseEntity<?> deleteAdmin(Integer id) {
        Optional<User> optional = this.userRepository.findById(id);
        if (optional.isPresent()) {
            User user = optional.get();
            this.userRepository.delete(user);
            return ResponseEntity.ok("deleted successfully");
        }
        return ResponseEntity.ok("User not found");
    }

    @Override
    public ResponseEntity<?> findAllAdmin() {
        List<User> allAdmin = this.userRepository.findAllAdmin();
        if (!allAdmin.isEmpty()) {
            return ResponseEntity.ok(allAdmin);
        }
        return ResponseEntity.ok("List is empty");
    }
}
