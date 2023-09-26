package com.HotelManagement.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationDTO {

    private Long id;

    private HotelDTO hotel;

    private RoomDTO room;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private Double totalPrice;
}
