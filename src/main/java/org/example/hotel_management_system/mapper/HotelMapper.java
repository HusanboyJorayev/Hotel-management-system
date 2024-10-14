package org.example.hotel_management_system.mapper;

import lombok.RequiredArgsConstructor;
import org.example.hotel_management_system.dto.HotelDto;
import org.example.hotel_management_system.entity.Hotel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class HotelMapper {

    public Hotel toEntity(HotelDto.CreateHotel dto) {
        return Hotel.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .city(dto.getCity())
                .phone(dto.getPhone())
                .district(dto.getDistrict())
                .country(dto.getCountry())
                .build();
    }

    public HotelDto toDto(Hotel entity) {
        return HotelDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .city(entity.getCity())
                .phone(entity.getPhone())
                .district(entity.getDistrict())
                .country(entity.getCountry())
                .build();
    }

    public void update(HotelDto.CreateHotel dto, Hotel entity) {
        if (dto == null)
            return;
        if (dto.getName() != null)
            entity.setName(dto.getName());
        if (dto.getAddress() != null)
            entity.setAddress(dto.getAddress());
        if (dto.getCity() != null)
            entity.setCity(dto.getCity());
        if (dto.getPhone() != null)
            entity.setPhone(dto.getPhone());
        if (dto.getDistrict() != null)
            entity.setDistrict(dto.getDistrict());
        if (dto.getCountry() != null)
            entity.setCountry(dto.getCountry());
    }

    public List<HotelDto> getAll(List<Hotel> entities) {
        if (!entities.isEmpty())
            return entities.stream().map(this::toDto).toList();
        return new ArrayList<>();
    }
}
