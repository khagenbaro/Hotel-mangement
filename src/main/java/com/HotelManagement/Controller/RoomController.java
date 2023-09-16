package com.HotelManagement.Controller;

import com.HotelManagement.dto.RoomDTO;
import com.HotelManagement.services.RoomService;
import jakarta.annotation.security.PermitAll;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private RoomService roomService;
    @GetMapping("/getRooms")
    public String getRooms(){
        return  "Rooms";
    }
    @PostMapping("/addRoom")
    @PermitAll
    public ResponseEntity<String> addRoom(@RequestBody RoomDTO roomDTO) {
        System.out.println("Hi");
        try {
            String result = roomService.addRooms(roomDTO);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }
}
