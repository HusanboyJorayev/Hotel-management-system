package org.example.hotel_management_system.service;

import org.example.hotel_management_system.dto.HotelDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface HotelService {

    ResponseEntity<?> createHotel(HotelDto.CreateHotel hotel);

    ResponseEntity<?> get(Integer id);

    ResponseEntity<?> update(HotelDto.CreateHotel hotel, Integer id);

    ResponseEntity<?> delete(Integer id);

    ResponseEntity<?> getAllHotel(Integer ownerId);

    ResponseEntity<?> getAllHotel();
}
