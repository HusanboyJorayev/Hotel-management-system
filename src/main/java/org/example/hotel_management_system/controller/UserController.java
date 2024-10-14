package org.example.hotel_management_system.controller;

import lombok.RequiredArgsConstructor;
import org.example.hotel_management_system.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/chooseHotel")
    public ResponseEntity<?> chooseHotel(@RequestParam("hotelId") Integer hotelId,
                                         @RequestParam("userId") Integer userId) {
        return ResponseEntity.ok(this.userService.chooseHotel(hotelId, userId));
    }

    @GetMapping("/chooseRoom")
    public ResponseEntity<?> chooseRoom(@RequestParam("roomId") Integer roomId,
                                        @RequestParam("userId") Integer userId,
                                        @RequestParam("numberOfPeople") Integer numberOfPeople) {
        return ResponseEntity.ok(this.userService.chooseRoom(roomId, userId, numberOfPeople));

    }
}
