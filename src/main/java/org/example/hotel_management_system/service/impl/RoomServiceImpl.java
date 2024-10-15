package org.example.hotel_management_system.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.hotel_management_system.dto.RoomDto;
import org.example.hotel_management_system.entity.Hotel;
import org.example.hotel_management_system.entity.Room;
import org.example.hotel_management_system.mapper.RoomMapper;
import org.example.hotel_management_system.repository.HotelRepository;
import org.example.hotel_management_system.repository.RoomRepository;
import org.example.hotel_management_system.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;
    private final HotelRepository hotelRepository;

    @Override
    public ResponseEntity<?> create(RoomDto.CreateDto dto) {
        if (this.hotelRepository.findById(dto.getHotelId()).isPresent()) {
            Room entity = this.roomMapper.toEntity(dto);
            this.roomRepository.save(entity);
            return ResponseEntity.ok(this.roomMapper.toDto(entity));
        }
        return ResponseEntity.ok("Hotel does not exist");
    }

    @Override
    public ResponseEntity<?> get(Integer id) {
        Optional<Room> roomOptional = this.roomRepository.findById(id);
        if (roomOptional.isPresent()) {
            Room room = roomOptional.get();
            return ResponseEntity.ok(this.roomMapper.toDto(room));
        }
        return ResponseEntity.ok("Room does not exist");
    }

    @Override
    public ResponseEntity<?> update(RoomDto.CreateDto dto, Integer id) {
        Optional<Hotel> optional = this.hotelRepository.findById(dto.getHotelId());
        if (optional.isPresent()) {
            Optional<Room> roomOptional = this.roomRepository.findById(id);
            if (roomOptional.isPresent()) {
                Room room = roomOptional.get();
                this.roomMapper.update(dto, room);
                this.roomRepository.save(room);
                return ResponseEntity.ok(this.roomMapper.toDto(room));
            }
            return ResponseEntity.ok("Room does not exist");
        }
        return ResponseEntity.ok("Hotel does not exist");
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        Optional<Room> roomOptional = this.roomRepository.findById(id);
        if (roomOptional.isPresent()) {
            Room room = roomOptional.get();
            this.roomRepository.delete(room);
            return ResponseEntity.ok("Room deleted successfully");
        }
        return ResponseEntity.ok("Room does not exist");
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<Room> roomList = this.roomRepository.findAll();
        if (!roomList.isEmpty())
            return ResponseEntity.ok(this.roomMapper.toDtoList(roomList));
        return ResponseEntity.ok("List is empty");
    }
}
