package org.example.hotel_management_system.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.hotel_management_system.dto.RoomDto;
import org.example.hotel_management_system.repository.RoomRepository;
import org.example.hotel_management_system.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Override
    public ResponseEntity<?> create(RoomDto.CreateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<?> get(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(RoomDto.CreateDto dto, Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAll() {
        return null;
    }
}
