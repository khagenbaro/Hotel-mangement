package com.HotelManagement.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private int roomNumber;
    private double price;
    private String hotelName;
    private RoomType roomType;


}
