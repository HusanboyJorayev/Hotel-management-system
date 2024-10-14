package org.example.hotel_management_system.service;

import org.example.hotel_management_system.dto.RoomDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface RoomService {

    ResponseEntity<?> create(RoomDto.CreateDto dto);

    ResponseEntity<?> get(Integer id);

    ResponseEntity<?> update(RoomDto.CreateDto dto, Integer id);

    ResponseEntity<?> delete(Integer id);

    ResponseEntity<?> getAll();
}
