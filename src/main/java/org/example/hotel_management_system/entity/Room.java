package org.example.hotel_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hotel_management_system.roles.RoomState;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "room")
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;
    private String description;
    private Boolean enable = true;
    private Integer numberOfPeople;
    private Double price;
    private Integer hotelId;
    @Enumerated(EnumType.STRING)
    private RoomState status = RoomState.ACTIVE;
    @Enumerated(EnumType.STRING)
    private RoomState state = RoomState.EMPTY;
}
