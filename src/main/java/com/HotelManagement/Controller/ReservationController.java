package com.HotelManagement.Controller;

import com.HotelManagement.dto.ReservationDTO;
import com.HotelManagement.modal.Reservation;
import com.HotelManagement.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/getAllReservation")
    public ResponseEntity<List<Reservation>> getAllReservation(){
        List<Reservation> reservationList = reservationService.getReservationList();
        return ResponseEntity.ok(reservationList);
    }
    @PostMapping("/reserveARoom")
    public ResponseEntity<String> reserveARoom(@RequestBody ReservationDTO reservationDTO){
        String result = reservationService.reserveARoom(reservationDTO);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/getReservationById")
    public ResponseEntity<Optional<Reservation>> getReservationById(@RequestParam long id){
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        return ResponseEntity.ok(reservation);
    }
    @DeleteMapping("/deleteReservation")
    public ResponseEntity<String> deleteReservation(@RequestParam long id){
        String result = reservationService.deleteReservationById(id);
        return  ResponseEntity.ok(result);
    }
}
