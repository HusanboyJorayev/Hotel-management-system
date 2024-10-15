package org.example.hotel_management_system.schedule;

import lombok.RequiredArgsConstructor;
import org.example.hotel_management_system.entity.Order;
import org.example.hotel_management_system.entity.Room;
import org.example.hotel_management_system.repository.OrderRepository;
import org.example.hotel_management_system.repository.RoomRepository;
import org.example.hotel_management_system.roles.RoomState;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@EnableScheduling
@RequiredArgsConstructor
public class HotelSchedule {
    private final OrderRepository orderRepository;
    private final RoomRepository roomRepository;


    // check every 5 seconds
    @Scheduled(cron = "*/5 * * * * *")
    public void checkRoomActiveOrInactive() {
        List<Order> orders = this.orderRepository.findAll();
        for (Order order : orders) {
            if (order.getBeginDate().isAfter(LocalDate.now()) && order.getEndDate().isBefore(LocalDate.now())) {
                Optional<Room> roomOptional = this.roomRepository.findById(order.getRoomId());
                if (roomOptional.isPresent()) {
                    Room room = roomOptional.get();
                    room.setState(RoomState.EMPTY);
                    this.roomRepository.save(room);
                }
            }
        }
    }
}
