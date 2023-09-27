package com.HotelManagement.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dinning")
public class DinningController {

   /* Restaurants and cafes offering various cuisines.
    Room service for in-room dining.
    Breakfast, lunch, and dinner options.
            Catering for events and conferences.*/
    public ResponseEntity<String> addBreakfast(){

        return ResponseEntity.ok("added");
    }

}
