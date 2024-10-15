package org.example.hotel_management_system.controller;

import lombok.RequiredArgsConstructor;
import org.example.hotel_management_system.dto.RoomDto;
import org.example.hotel_management_system.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody RoomDto.CreateDto dto) {
        return ResponseEntity.ok(this.roomService.create(dto));
    }

    @GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(this.roomService.get(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody RoomDto.CreateDto dto,
                                    @RequestParam("id") Integer id) {
        return ResponseEntity.ok(this.roomService.update(dto, id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(this.roomService.delete(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.roomService.getAll());
    }
}
