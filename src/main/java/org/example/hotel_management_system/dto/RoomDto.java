package org.example.hotel_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDto {
    private Integer id;
    private String number;
    private String description;
    private Boolean enable = true;
    private Integer numberOfPeople;
    private Double price;
    private Integer hotelId;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CreateDto {
        private String number;
        private String description;
        private Boolean enable = true;
        private Integer numberOfPeople;
        private Double price;
        private Integer hotelId;
    }
}
