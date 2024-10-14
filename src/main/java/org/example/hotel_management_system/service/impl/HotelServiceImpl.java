package org.example.hotel_management_system.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.hotel_management_system.dto.HotelDto;
import org.example.hotel_management_system.entity.Hotel;
import org.example.hotel_management_system.mapper.HotelMapper;
import org.example.hotel_management_system.repository.HotelRepository;
import org.example.hotel_management_system.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;


    @Override
    public ResponseEntity<?> createHotel(HotelDto.CreateHotel hotel) {
        Hotel entity = this.hotelMapper.toEntity(hotel);
        this.hotelRepository.save(entity);
        return ResponseEntity.ok(this.hotelMapper.toDto(entity));
    }

    @Override
    public ResponseEntity<?> get(Integer id) {
        Optional<Hotel> optional = this.hotelRepository.findById(id);
        if (optional.isPresent()) {
            Hotel hotel = optional.get();
            return ResponseEntity.ok(this.hotelMapper.toDto(hotel));
        }
        return ResponseEntity.ok("hotel not found");
    }

    @Override
    public ResponseEntity<?> update(HotelDto.CreateHotel hotel, Integer id) {
        Optional<Hotel> optional = this.hotelRepository.findById(id);
        if (optional.isPresent()) {
            Hotel entity = optional.get();
            this.hotelMapper.update(hotel, entity);
            this.hotelRepository.save(entity);
            return ResponseEntity.ok(this.hotelMapper.toDto(entity));
        }
        return ResponseEntity.ok("hotel not found");
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        Optional<Hotel> optional = this.hotelRepository.findById(id);
        if (optional.isPresent()) {
            this.hotelRepository.deleteById(id);
            return ResponseEntity.ok("hotel deleted successfully");
        }
        return ResponseEntity.ok("hotel not found");
    }

    @Override
    public ResponseEntity<?> getAllHotel(Integer ownerId) {
        List<Hotel> list = this.hotelRepository.findByOwnerId(ownerId);
        if (!list.isEmpty())
            return ResponseEntity.ok(this.hotelMapper.getAll(list));
        return ResponseEntity.ok(new ArrayList<>());
    }

    @Override
    public ResponseEntity<?> getAllHotel() {
        List<Hotel> list = this.hotelRepository.findAll();
        if (!list.isEmpty())
            return ResponseEntity.ok(this.hotelMapper.getAll(list));
        return ResponseEntity.ok(new ArrayList<>());
    }
}
