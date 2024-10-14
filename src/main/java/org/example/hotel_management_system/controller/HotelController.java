package org.example.hotel_management_system.controller;

import lombok.RequiredArgsConstructor;
import org.example.hotel_management_system.dto.HotelDto;
import org.example.hotel_management_system.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;


    @PostMapping("/create")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<?> createHotel(@RequestBody HotelDto.CreateHotel dto) {
        return ResponseEntity.ok(this.hotelService.createHotel(dto));
    }

    @GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(this.hotelService.get(id));
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<?> update(@RequestBody HotelDto.CreateHotel dto,
                                    @RequestParam("id") Integer id) {
        return ResponseEntity.ok(this.hotelService.update(dto, id));
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<?> delete(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(this.hotelService.delete(id));
    }

    @GetMapping("/getAllOwnHotel")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<?> getAllOwnHotel(@RequestParam("id") Integer ownerId) {
        return ResponseEntity.ok(this.hotelService.getAllHotel(ownerId));
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyRole('ADMIN','USER','SUPER_ADMIN')")
    public ResponseEntity<?> getAllHotel() {
        return ResponseEntity.ok(this.hotelService.getAllHotel());
    }
}
