package org.example.hotel_management_system.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.hotel_management_system.entity.Order;
import org.example.hotel_management_system.mapper.OrderMapper;
import org.example.hotel_management_system.repository.OrderRepository;
import org.example.hotel_management_system.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public ResponseEntity<?> getOrderById(Integer id) {
        Optional<Order> optional = this.orderRepository.findById(id);
        if (optional.isPresent()) {
            Order order = optional.get();
            return ResponseEntity.ok(orderMapper.toDto(order));
        }
        return ResponseEntity.ok("Order not found");
    }

    @Override
    public ResponseEntity<?> getOrderByUserId(Integer userId) {
        List<Order> list = this.orderRepository.findByUserId(userId);
        if (!list.isEmpty()) {
            return ResponseEntity.ok(this.orderMapper.toDtoList(list));
        }
        return ResponseEntity.ok("list is empty");
    }

    @Override
    public ResponseEntity<?> deleteById(Integer id) {
        Optional<Order> optional = this.orderRepository.findById(id);
        if (optional.isPresent()) {
            Order order = optional.get();
            this.orderRepository.delete(order);
            return ResponseEntity.ok("Order deleted successfully");
        }
        return ResponseEntity.ok("Order not found");
    }

    @Override
    public ResponseEntity<?> deleteByUserId(Integer id) {
        List<Order> list = this.orderRepository.findByUserId(id);
        if (!list.isEmpty()) {
            this.orderRepository.deleteAll(list);
            return ResponseEntity.ok("Order deleted successfully");
        }
        return ResponseEntity.ok("List is empty");
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<Order> list = this.orderRepository.findAll();
        if (!list.isEmpty()) {
            return ResponseEntity.ok(this.orderMapper.toDtoList(list));
        }
        return ResponseEntity.ok("list is empty");
    }
}
