package org.example.hotel_management_system.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface AdminService {

    ResponseEntity<?> updateAdmin(Integer id);

    ResponseEntity<?> deleteAdmin(Integer id);

    ResponseEntity<?> findAllAdmin();

    ResponseEntity<?> deleteUserById(Integer id);

    ResponseEntity<?> getAllUsers();
}
