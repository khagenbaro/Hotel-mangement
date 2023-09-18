package com.HotelManagement.dto;

import com.HotelManagement.modal.Address;
import lombok.Data;

import java.util.List;

@Data
public class HotelDTO {


    private String hotelName;

    private String city;

    private String state;

    private Address address;

    private List<RoomDTO> rooms;
}

