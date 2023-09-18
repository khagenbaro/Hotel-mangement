package com.HotelManagement.Controller;

import com.HotelManagement.dto.HotelDTO;
import com.HotelManagement.modal.Hotel;
import com.HotelManagement.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HptelController {
    @Autowired
    private HotelService hotelService;
    @GetMapping("getAllHotels")
    public ResponseEntity<List<Hotel>> getAllRooms(){
        List<Hotel> hotelList = hotelService.getAllHotels();
        return ResponseEntity.ok(hotelList);
    }
    @PostMapping("/addHotel")
    public ResponseEntity<String > addHotel(HotelDTO hotelDTO){
        String result = hotelService.addHotel(hotelDTO);
        return  ResponseEntity.ok(result);
    }
    @GetMapping("/getHotelById")
    public ResponseEntity<Optional<Hotel>> getHotelById(long id){
        Optional<Hotel> hotel = hotelService.getHotelById(id);
        return  ResponseEntity.ok(hotel);
    }

}
