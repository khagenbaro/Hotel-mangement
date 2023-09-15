package com.HotelManagement.dto;

import com.HotelManagement.modal.Address;
import com.HotelManagement.modal.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class HotelDTO {

    private long hotelId;

    private String hotelName;

    private String city;

    private String state;


    private Address address;


    private List<Room> rooms;
}

