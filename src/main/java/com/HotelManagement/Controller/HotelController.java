package com.HotelManagement.Controller;

import com.HotelManagement.dto.HotelDTO;
import com.HotelManagement.modal.Hotel;
import com.HotelManagement.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @GetMapping("/getAllHotels")
    public ResponseEntity<List<HotelDTO>> getAllRooms(){
        List<HotelDTO> hotelList = hotelService.getAllHotels();
        return ResponseEntity.ok(hotelList);
    }
    @PostMapping("/addHotel")
    public ResponseEntity<String > addHotel(@RequestBody HotelDTO hotelDTO){
        String result = hotelService.addHotel(hotelDTO);
        return  ResponseEntity.ok(result);
    }
    @GetMapping("/getHotelById")
    public ResponseEntity<HotelDTO> getHotelById(@RequestParam  long id){
        HotelDTO hotel = hotelService.getHotelById(id);
        return  ResponseEntity.ok(hotel);
    }
    @DeleteMapping("/deleteHotelById")
    public ResponseEntity<String> deleteHotelById(@RequestParam long id){
        String result = hotelService.deleteHotel(id);
        return ResponseEntity.ok(result);
    }


}
