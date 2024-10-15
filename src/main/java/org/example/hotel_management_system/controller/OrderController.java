package org.example.hotel_management_system.controller;

import lombok.RequiredArgsConstructor;
import org.example.hotel_management_system.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/getOrderById")
    public ResponseEntity<?> getOrderById(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @GetMapping("/getOrderByUserId")
    public ResponseEntity<?> getOrderByUserId(@RequestParam("user-id") Integer userId) {
        return ResponseEntity.ok(orderService.getOrderByUserId(userId));
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<?> deleteById(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(orderService.deleteById(id));
    }

    @DeleteMapping("/deleteByUserId")
    public ResponseEntity<?> deleteByUserId(@RequestParam("user-id") Integer userId) {
        return ResponseEntity.ok(orderService.deleteByUserId(userId));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }
}
