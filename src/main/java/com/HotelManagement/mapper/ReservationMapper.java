package com.HotelManagement.mapper;

import com.HotelManagement.dto.ReservationDTO;
import com.HotelManagement.modal.Reservation;

public class ReservationMapper {
    public ReservationDTO entityToDTO(Reservation reservation){
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setRoom(reservation.getRoom());
        reservationDTO.setHotel(reservation.getHotel());
        reservationDTO.setCheckInDate(reservation.getCheckInDate());
        reservationDTO.setCheckOutDate(reservation.getCheckOutDate());
        reservationDTO.setTotalPrice(reservation.getTotalPrice());

        return reservationDTO;
    }
    public Reservation dtoToEntity(ReservationDTO reservationDto){
        Reservation reservation = new Reservation();
        reservation.setRoom(reservationDto.getRoom());
        reservation.setHotel(reservationDto.getHotel());
        reservation.setCheckInDate(reservationDto.getCheckInDate());
        reservation.setCheckOutDate(reservationDto.getCheckOutDate());
        reservation.setTotalPrice(reservationDto.getTotalPrice());
        return reservation;
    }
}
