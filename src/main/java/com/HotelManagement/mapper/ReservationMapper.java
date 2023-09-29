package com.HotelManagement.mapper;

import com.HotelManagement.dto.ReservationDTO;
import com.HotelManagement.modal.Reservation;
import org.springframework.beans.factory.annotation.Autowired;

public class ReservationMapper {
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private HotelMapper hotelMapper;
    public ReservationDTO entityToDTO(Reservation reservation){
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setRoom(roomMapper.entityToDTO(reservation.getRoom()));
        reservationDTO.setHotel(hotelMapper.entityToDTO(reservation.getHotel()));
        reservationDTO.setCheckInDate(reservation.getCheckInDate());
        reservationDTO.setCheckOutDate(reservation.getCheckOutDate());
        reservationDTO.setTotalPrice(reservation.getTotalPrice());
        return reservationDTO;
    }
    public Reservation dtoToEntity(ReservationDTO reservationDto){
        Reservation reservation = new Reservation();
        reservation.setRoom(roomMapper.dtoToEntity(reservationDto.getRoom()));
        reservation.setHotel(hotelMapper.dtoToEntity(reservationDto.getHotel()));
        reservation.setCheckInDate(reservationDto.getCheckInDate());
        reservation.setCheckOutDate(reservationDto.getCheckOutDate());
        reservation.setTotalPrice(reservationDto.getTotalPrice());
        return reservation;
    }
}
