package org.example.hotel_management_system.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface OrderService {
    ResponseEntity<?> getOrderById(Integer id);

    ResponseEntity<?> getOrderByUserId(Integer userId);

    ResponseEntity<?> deleteById(Integer id);

    ResponseEntity<?> deleteByUserId(Integer id);

    ResponseEntity<?> getAll();
}
