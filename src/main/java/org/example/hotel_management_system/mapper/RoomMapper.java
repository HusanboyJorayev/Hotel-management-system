package org.example.hotel_management_system.mapper;

import org.example.hotel_management_system.dto.RoomDto;
import org.example.hotel_management_system.entity.Room;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomMapper {
    public Room toEntity(RoomDto.CreateDto dto) {
        return Room.builder()
                .description(dto.getDescription())
                .enable(dto.getEnable())
                .hotelId(dto.getHotelId())
                .price(dto.getPrice())
                .number(dto.getNumber())
                .numberOfPeople(dto.getNumberOfPeople())
                .build();
    }

    public RoomDto toDto(Room entity) {
        return RoomDto.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .enable(entity.getEnable())
                .hotelId(entity.getHotelId())
                .price(entity.getPrice())
                .number(entity.getNumber())
                .numberOfPeople(entity.getNumberOfPeople())
                .build();
    }

    public List<RoomDto> toDtoList(List<Room> entities) {
        if (entities.isEmpty())
            return new ArrayList<>();
        return entities
                .stream().map(this::toDto).toList();
    }

    public void update(RoomDto.CreateDto dto, Room entity) {
        if (dto == null)
            return;
        if (dto.getDescription() != null)
            entity.setDescription(dto.getDescription());
        if (dto.getEnable() != null)
            entity.setEnable(dto.getEnable());
        if (dto.getHotelId() != null)
            entity.setHotelId(dto.getHotelId());
        if (dto.getPrice() != null)
            entity.setPrice(dto.getPrice());
        if (dto.getNumber() != null)
            entity.setNumber(dto.getNumber());
        if (dto.getNumberOfPeople() != null)
            entity.setNumberOfPeople(dto.getNumberOfPeople());
    }
}
