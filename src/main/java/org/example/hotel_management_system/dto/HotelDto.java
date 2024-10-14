package org.example.hotel_management_system.dto;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelDto {
    private Integer id;
    private String name;
    private String address;
    private String city;
    private String district;
    private String country;
    private String phone;



    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CreateHotel {
        private String name;
        private String address;
        private String city;
        private String district;
        private String country;
        private String phone;
    }
}
