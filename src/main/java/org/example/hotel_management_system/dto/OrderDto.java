package org.example.hotel_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Integer id;
    private Integer userId;
    private Integer roomId;
    private Integer numberOfPeople;
    private LocalDate beginDate;
    private LocalDate endDate;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CreateOrder {
        private Integer userId;
        private Integer roomId;
        private Integer numberOfPeople;
        private LocalDate beginDate;
        private LocalDate endDate;
    }
}
