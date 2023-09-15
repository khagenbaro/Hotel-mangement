package com.HotelManagement.dto;

import com.HotelManagement.modal.RoomType;
import lombok.Data;

@Data
public class RoomDTO {
    private int roomNumber;

    private double price;

    private String hotelName;

    private RoomType roomType;
}
