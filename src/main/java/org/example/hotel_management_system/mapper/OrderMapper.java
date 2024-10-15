package org.example.hotel_management_system.mapper;

import lombok.RequiredArgsConstructor;
import org.example.hotel_management_system.dto.OrderDto;
import org.example.hotel_management_system.entity.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    public Order toEntity(OrderDto.CreateOrder dto) {
        return Order.builder()
                .beginDate(dto.getBeginDate())
                .endDate(dto.getEndDate())
                .numberOfPeople(dto.getNumberOfPeople())
                .userId(dto.getUserId())
                .roomId(dto.getRoomId())
                .build();
    }

    public OrderDto toDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .beginDate(order.getBeginDate())
                .endDate(order.getEndDate())
                .numberOfPeople(order.getNumberOfPeople())
                .userId(order.getUserId())
                .roomId(order.getRoomId())
                .build();
    }

    public void update(OrderDto.CreateOrder dto, Order order) {
        if (dto == null)
            return;
        if (dto.getBeginDate() != null)
            order.setBeginDate(dto.getBeginDate());
        if (dto.getEndDate() != null)
            order.setEndDate(dto.getEndDate());
        if (dto.getUserId() != null)
            order.setUserId(dto.getUserId());
        if (dto.getRoomId() != null)
            order.setRoomId(dto.getRoomId());
        if (dto.getNumberOfPeople() != null)
            order.setNumberOfPeople(dto.getNumberOfPeople());
    }

    public List<OrderDto> toDtoList(List<Order> orders) {
        if (!orders.isEmpty()) {
            return orders.stream().map(this::toDto).toList();
        }
        return new ArrayList<>();
    }
}
