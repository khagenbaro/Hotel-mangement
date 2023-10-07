package com.HotelManagement.Controller;

import com.HotelManagement.dto.LunchMenuDTO;
import com.HotelManagement.services.LunchServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/lunch")
public class LunchController {
    @Autowired
    private LunchServices lunchServices;

    @PostMapping("/addLunchMenu")
    public ResponseEntity<String> addLunchMenu(LunchMenuDTO lunchMenuDTO){
        return ResponseEntity.ok(lunchServices.addLunchMenu(lunchMenuDTO));
    }
}
