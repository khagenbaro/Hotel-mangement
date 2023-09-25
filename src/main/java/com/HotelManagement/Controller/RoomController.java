package com.HotelManagement.Controller;

import com.HotelManagement.dto.RoomDTO;
import com.HotelManagement.modal.Room;
import com.HotelManagement.services.RoomService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
@NoArgsConstructor
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/getAllRooms")
    public ResponseEntity<List<RoomDTO>> getRooms(){
        List<RoomDTO> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }
    @GetMapping("/getRoomById")
    public ResponseEntity<RoomDTO> getRoomById(@RequestParam long id){
        RoomDTO roomDTO = roomService.getRoomById(id);
        return  ResponseEntity.ok(roomDTO);
    }
    @PostMapping("/addRoom")
    public ResponseEntity<String> addRoom(@RequestBody RoomDTO roomDTO) {
            String result = roomService.addRooms(roomDTO);
            return ResponseEntity.ok(result);
    }
    @DeleteMapping("/deleteRoomById")
    public ResponseEntity<String> deleteRoom(@RequestParam long id){
        String result = roomService.deleteRoomById(id);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/updateRoom")
    public ResponseEntity<String> updateRoom(@RequestParam long id, @RequestBody RoomDTO roomDTO){
        String result = roomService.updateRoom(id , roomDTO);
        return  ResponseEntity.ok(result);
    }

}
