package com.HotelManagement.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @GetMapping("/getRooms")
    public String getRooms(){
        return  "Rooms";
    }
}
