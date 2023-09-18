package com.HotelManagement.services;

import com.HotelManagement.dto.ReservationDTO;
import com.HotelManagement.modal.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReservationService {
    List<Reservation> getReservationList();
    Optional<Reservation> getReservationById(Long id);
    String reserveARoom(ReservationDTO reservationDTO);
    String deleteReservationById(long id);
}
