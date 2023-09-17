package com.HotelManagement.Controller;

import com.HotelManagement.dto.RoomDTO;
import com.HotelManagement.modal.Room;
import com.HotelManagement.services.RoomService;
import jakarta.annotation.security.PermitAll;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@NoArgsConstructor
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/getRooms")
    public ResponseEntity<List<Room>> getRooms(){
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }
    /*
    * Controller to add room*/
    @PostMapping("/addRoom")
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
