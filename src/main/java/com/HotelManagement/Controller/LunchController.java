package com.HotelManagement.Controller;

import com.HotelManagement.dto.LunchMenuDTO;
import com.HotelManagement.services.LunchServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/lunch")
public class LunchController {
    @Autowired
    private LunchServices lunchServices;

    @PostMapping("/addLunchMenu")
    public ResponseEntity<java.lang.String> addLunchMenu(@RequestBody LunchMenuDTO lunchMenuDTO){
        return ResponseEntity.ok(lunchServices.addLunchMenu(lunchMenuDTO));
    }
    @PutMapping("/updateLunchMenu")
    public ResponseEntity<String>  updateLunchMenu(@RequestParam long id , @RequestBody LunchMenuDTO lunchMenuDTO){
        return ResponseEntity.ok(lunchServices.updateLunchMenu(id,lunchMenuDTO));
    }
    @GetMapping("/getAllLunchMenu")
    public ResponseEntity<List<LunchMenuDTO>> getAllLunchMenu(){
        List<LunchMenuDTO> lunchMenuDTOList = lunchServices.getAllLunchMenu();
        return ResponseEntity.ok(lunchMenuDTOList);
    }

}
